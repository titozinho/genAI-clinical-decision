package com.capgemini.genai.clinicaldecision.repository;

import com.capgemini.genai.clinicaldecision.model.ClinicHospital;
import com.capgemini.genai.clinicaldecision.model.TypeClinicHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ClinicHospitalRepository extends JpaRepository<ClinicHospital, Long> {
    // Método para buscar clínicas/hospitais pelo nome
    List<ClinicHospital> findByNameContaining(String name);

    // Método para buscar clínicas/hospitais por tipo
    List<ClinicHospital> findByType(TypeClinicHospital type);
}
