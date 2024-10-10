package com.capgemini.genai.clinicaldecision.service;

import com.capgemini.genai.clinicaldecision.model.Anamnesis;
import com.capgemini.genai.clinicaldecision.repository.AnamnesisRepository; // Assegure-se de que esse repositório está implementado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnamnesisService {

    private final AnamnesisRepository anamnesisRepository;

    @Autowired
    public AnamnesisService(AnamnesisRepository anamnesisRepository) {
        this.anamnesisRepository = anamnesisRepository;
    }

    // Método para registrar uma nova anamnesis
    public Anamnesis registerAnamnesis(Anamnesis anamnesis) {
        return anamnesisRepository.save(anamnesis);
    }

    // Método para obter uma anamnesis por ID
    public Optional<Anamnesis> getAnamnesis(Long id) {
        return anamnesisRepository.findById(id);
    }

    // Método para obter todas as anamneses
    public List<Anamnesis> getAllAnamneses() {
        return anamnesisRepository.findAll();
    }

    // Método para atualizar uma anamnesis
    public Anamnesis updateAnamnesis(Long id, Anamnesis updatedAnamnesis) {
        if (anamnesisRepository.existsById(id)) {
            updatedAnamnesis.setId(id);
            return anamnesisRepository.save(updatedAnamnesis);
        }
        return null; // Ou você pode lançar uma exceção
    }

    // Método para deletar uma anamnesis
    public void deleteAnamnesis(Long id) {
        anamnesisRepository.deleteById(id);
    }
}
