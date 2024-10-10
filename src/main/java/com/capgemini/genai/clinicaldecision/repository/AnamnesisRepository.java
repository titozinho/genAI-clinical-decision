package com.capgemini.genai.clinicaldecision.repository;

import com.capgemini.genai.clinicaldecision.model.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnamnesisRepository extends JpaRepository<Anamnesis, Long> {
    // Método para encontrar anamneses por ID do paciente
    List<Anamnesis> findByPatientId(Long patientId);

    // Método para encontrar anamneses por ID do médico
    List<Anamnesis> findByDoctorId(Long doctorId);

    // Método para encontrar anamneses por ID da clínica/hospital
    List<Anamnesis> findByClinicHospitalId(Long clinicHospitalId);

    // Método para encontrar anamneses que contenham certos sintomas
    List<Anamnesis> findBySymptomsContaining(String symptoms);

    // Método para buscar anamneses por diagnóstico
    List<Anamnesis> findByDiagnosisContaining(String diagnosis);
}
