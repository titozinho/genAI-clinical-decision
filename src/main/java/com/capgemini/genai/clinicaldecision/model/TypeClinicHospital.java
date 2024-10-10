package com.capgemini.genai.clinicaldecision.model;

import lombok.Getter;

@Getter
public enum TypeClinicHospital {
    CLINIC("Clinic"),
    HOSPITAL("Hospital");

    private final String displayName;

    TypeClinicHospital(String displayName) {
        this.displayName = displayName;
    }
}
