package com.capgemini.genai.clinicaldecision.controller;

import com.capgemini.genai.clinicaldecision.model.Patient;
import com.capgemini.genai.clinicaldecision.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListPatients() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        when(patientService.getAllPatients()).thenReturn(patients);

        List<Patient> result = patientController.listPatients();

        verify(patientService, times(1)).getAllPatients();
        assertEquals(patients, result);
    }

    @Test
    void testRegisterPatient() {
        Patient patient = new Patient();
        when(patientService.registerPatient(patient)).thenReturn(patient);

        Patient result = patientController.registerPatient(patient);

        verify(patientService, times(1)).registerPatient(patient);
        assertEquals(patient, result);
    }

    @Test
    void testSearchPatients() {
        String name = "John";
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient());
        when(patientService.searchPatients(name)).thenReturn(patients);

        List<Patient> result = patientController.searchPatients(name);

        verify(patientService, times(1)).searchPatients(name);
        assertEquals(patients, result);
    }
}
