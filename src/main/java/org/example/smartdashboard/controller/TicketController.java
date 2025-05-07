package org.example.smartdashboard.controller;


import org.example.smartdashboard.model.Ticket;
import org.example.smartdashboard.service.TicketService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ticket> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarByDate")
    public List<Ticket> findAllByDataAberturaBetween(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM") Calendar date, @RequestParam String orderByTerm) {
        return service.findAllByDataAberturaBetween(LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault()), orderByTerm);
    }

    @PostMapping
    public Ticket criar(@RequestBody Ticket Ticket) {
        if (Ticket.getDataAbertura() == null) {
            Ticket.setDataAbertura(LocalDate.now());
        }
        return service.salvar(Ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> atualizar(@PathVariable Long id, @RequestBody Ticket ticketAtualizada) {
        return service.buscarPorId(id)
                .map(ticketExistente -> {
                    ticketExistente.setTitulo(ticketAtualizada.getTitulo());
                    ticketExistente.setCliente(ticketAtualizada.getCliente());
                    ticketExistente.setModulo(ticketAtualizada.getModulo());
                    ticketExistente.setDataEncerramento(ticketAtualizada.getDataEncerramento());
                    return ResponseEntity.ok(service.salvar(ticketExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
