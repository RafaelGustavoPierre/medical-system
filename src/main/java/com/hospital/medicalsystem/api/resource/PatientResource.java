package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.model.PatientAdmission;
import com.hospital.medicalsystem.domain.service.PatientHistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientResource {

    private final PatientHistoricService patientHistoricService;

    @PostMapping("/{id}/admissions")
    public PatientAdmission admitPatient(@PathVariable Long id) {
        return patientHistoricService.admitPatient(id);
    }

}
