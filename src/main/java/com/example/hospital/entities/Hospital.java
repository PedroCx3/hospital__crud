package com.example.hospital.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb.hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String endereço;
    private int capacidadetotal;
    private int numerodeleito;

    @ManyToOne
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<paciente> pacientesInternados;

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadetotal() {
        return capacidadetotal;
    }

    public void setCapacidadetotal(int capacidadetotal) {
        this.capacidadetotal = capacidadetotal;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getNumerodeleito() {
        return numerodeleito;
    }

    public void setNumerodeleito(int numerodeleito) {
        this.numerodeleito = numerodeleito;

    }
}
