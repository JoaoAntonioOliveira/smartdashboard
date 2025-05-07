package org.example.smartdashboard.repository;

import org.example.smartdashboard.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
