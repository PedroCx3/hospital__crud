package com.example.hospital.controller;

import com.example.hospital.Repository.PacienteRepository;
import com.example.hospital.entities.paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Listar todos os pacientes
    @GetMapping
    public List<paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Obter um paciente por ID
    @GetMapping("/{id}")
    public paciente obterPacientePorId(@PathVariable Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    // Criar um novo paciente
    @PostMapping
    public paciente criarPaciente(@RequestBody paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Atualizar um paciente por ID
    @PutMapping("/{id}")
    public paciente atualizarPaciente(@PathVariable Long id, @RequestBody paciente paciente) {
        paciente pacienteExistente = pacienteRepository.findById(id).orElse(null);

        if (pacienteExistente != null) {
            pacienteExistente.setNome(paciente.getNome());
            pacienteExistente.setIdade(paciente.getIdade());
            pacienteExistente.setGenero(paciente.getGenero());
            pacienteExistente.setDataAdmissao(paciente.getDataAdmissao());
            pacienteExistente.setEmQuarentena(paciente.isEmQuarentena());

            return pacienteRepository.save(pacienteExistente);
        } else {
            // Lidar com o paciente não encontrado
            return null;
        }
    }

    // Deletar um paciente por ID
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }
}

