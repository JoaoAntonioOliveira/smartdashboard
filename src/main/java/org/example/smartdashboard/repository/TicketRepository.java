package org.example.smartdashboard.repository;

import org.example.smartdashboard.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByDataAberturaBetween(LocalDate dataAberturaInicio, LocalDate dataAberturaFinal);
}
