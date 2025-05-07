package org.example.smartdashboard.service;

import org.example.smartdashboard.model.Ticket;
import org.example.smartdashboard.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> listarTodos() {
        return repository.findAll();
    }

    public Optional<Ticket> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Ticket> findAllByDataAberturaBetween(LocalDate date) {
        LocalDate dateInicio = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate dateFim = dateInicio.withDayOfMonth(dateInicio.lengthOfMonth());

        return repository.findAllByDataAberturaBetween(dateInicio, dateFim);
    }

    public Ticket salvar(Ticket ticket) {
        return repository.save(ticket);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}