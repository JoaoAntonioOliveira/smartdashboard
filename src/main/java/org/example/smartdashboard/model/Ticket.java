package org.example.smartdashboard.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = -2988833390999677039L;

    @Id
    @SequenceGenerator(name = "seq_ticket", sequenceName = "seq_ticket", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ticket")
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_encerramento")
    private LocalDate dataEncerramento;

    public Ticket() {
    }

    public Ticket(Long id, String titulo, Cliente cliente, Modulo modulo, LocalDate dataAbertura, LocalDate dataEncerramento) {
        this.id = id;
        this.titulo = titulo;
        this.cliente = cliente;
        this.modulo = modulo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    @Override
    public String toString() {
        return titulo;
    }
}