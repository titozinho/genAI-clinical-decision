package com.capgemini.genai.clinicaldecision.service;

import com.capgemini.genai.clinicaldecision.model.ClinicHospital;
import com.capgemini.genai.clinicaldecision.model.TypeClinicHospital;
import com.capgemini.genai.clinicaldecision.repository.ClinicHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicHospitalService {

    private final ClinicHospitalRepository clinicHospitalRepository;

    @Autowired
    public ClinicHospitalService(ClinicHospitalRepository clinicHospitalRepository) {
        this.clinicHospitalRepository = clinicHospitalRepository;
    }

    // Método para registrar uma nova clínica/hospital
    public ClinicHospital registerClinicHospital(ClinicHospital clinicHospital) {
        return clinicHospitalRepository.save(clinicHospital);
    }

    // Método para obter uma clínica/hospital por ID
    public Optional<ClinicHospital> getClinicHospital(Long id) {
        return clinicHospitalRepository.findById(id);
    }

    // Método para obter todas as clínicas/hospitais
    public List<ClinicHospital> getAllClinicsHospitals() {
        return clinicHospitalRepository.findAll();
    }

    // Método para atualizar uma clínica/hospital
    public ClinicHospital updateClinicHospital(Long id, ClinicHospital updatedClinicHospital) {
        if (clinicHospitalRepository.existsById(id)) {
            updatedClinicHospital.setId(id);
            return clinicHospitalRepository.save(updatedClinicHospital);
        }
        return null; // Ou você pode lançar uma exceção
    }

    // Método para deletar uma clínica/hospital
    public void deleteClinicHospital(Long id) {
        clinicHospitalRepository.deleteById(id);
    }

    // Método para buscar clínicas/hospitais pelo nome
    public List<ClinicHospital> searchClinicsHospitals(String name) {
        return clinicHospitalRepository.findByNameContaining(name);
    }

    // Método para buscar clínicas/hospitais pelo tipo
    public List<ClinicHospital> findByType(TypeClinicHospital type) {
        return clinicHospitalRepository.findByType(type);
    }
}
