package com.capgemini.genai.clinicaldecision.service;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> searchPatients(String name) {
        return patientRepository.findByNameContaining(name);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Método para registrar múltiplos pacientes
    public List<Patient> registerPatients(List<Patient> patients) {
        return patients.stream()
                .map(this::registerPatient)
                .collect(Collectors.toList());
    }
}

