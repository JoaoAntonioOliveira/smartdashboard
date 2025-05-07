package org.example.smartdashboard.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {

    private static final long serialVersionUID = -2431948799267939104L;

    @Id
    @SequenceGenerator(name = "seq_modulo", sequenceName = "seq_modulo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_modulo")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Modulo() {
    }

    public Modulo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}