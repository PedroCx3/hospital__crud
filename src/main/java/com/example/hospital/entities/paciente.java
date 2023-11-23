package com.example.hospital.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tb_passiente")
public class paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    private char genero;
    private LocalDate dataAdmissao;
    private boolean emQuarentena;

    @ManyToOne
    @JoinColumn(name = "Hospital_id")
    private Hospital hospital;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public boolean isEmQuarentena() {
        return emQuarentena;
    }
    public void setEmQuarentena(boolean emQuarentena) {
        this.emQuarentena = emQuarentena;
    }

    public char getGenero() {
        return genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}

