package com.example.hospital.controller;

import com.example.hospital.Repository.HospitalRepository;
import com.example.hospital.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitais")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    // Listar todos os hospitais
    @GetMapping
    public List<Hospital> listarHospitais() {
        return hospitalRepository.findAll();
    }

    // Obter um hospital por ID
    @GetMapping("/{id}")
    public Hospital obterHospitalPorId(@PathVariable Long id) {
        return hospitalRepository.findById(id).orElse(null);
    }

    // Criar um novo hospital
    @PostMapping
    public Hospital criarHospital(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    // Atualizar um hospital por ID
    @PutMapping("/{id}")
    public Hospital atualizarHospital(@PathVariable Long id, @RequestBody Hospital hospital) {
        Hospital hospitalExistente = hospitalRepository.findById(id).orElse(null);

        if (hospitalExistente != null) {
            hospitalExistente.setNome(hospital.getNome());
            hospitalExistente.setEndereço(hospital.getEndereço());
            hospitalExistente.setCapacidadetotal(hospital.getCapacidadetotal());
            hospitalExistente.setNumerodeleito(hospital.getNumerodeleito());

            return hospitalRepository.save(hospitalExistente);
        } else {
            // Lidar com o hospital não encontrado
            return null;
        }
    }

    // Deletar um hospital por ID
    @DeleteMapping("/{id}")
    public void deletarHospital(@PathVariable Long id) {
        hospitalRepository.deleteById(id);
    }
}

