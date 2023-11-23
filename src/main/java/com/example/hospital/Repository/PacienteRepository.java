package com.example.hospital.Repository;
import com.example.hospital.entities.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface PacienteRepository extends JpaRepository<paciente, Long> {
        // Métodos de repositório padrão já fornecidos pelo JpaRepository
    }
