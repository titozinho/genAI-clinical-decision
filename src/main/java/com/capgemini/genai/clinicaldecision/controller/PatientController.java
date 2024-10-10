package com.capgemini.genai.clinicaldecision.controller;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.service.PatientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Listar todos os pacientes
    @GetMapping
    public List<Patient> listPatients() {
        return patientService.getAllPatients();
    }

    // Registrar um novo paciente
    @PostMapping(value = "/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        patientService.registerPatient(patient);
        return patient; // Retorna o paciente recém-cadastrado
    }

    // Pesquisar pacientes pelo nome
    @PostMapping("/search")
    public List<Patient> searchPatients(@RequestParam String name) {
        return patientService.searchPatients(name);
    }

    // Registrar múltiplos pacientes
    @PostMapping("/register/batch")
    public ResponseEntity<List<Patient>> registerPatients(@RequestBody List<Patient> patients) {
        try {
            List<Patient> registeredPatients = patients.stream()
                    .map(patientService::registerPatient)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(registeredPatients, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}