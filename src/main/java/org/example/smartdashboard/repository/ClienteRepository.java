package org.example.smartdashboard.repository;

import org.example.smartdashboard.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
