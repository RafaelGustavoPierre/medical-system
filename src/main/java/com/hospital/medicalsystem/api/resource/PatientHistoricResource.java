package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.domain.model.Patient;
import com.hospital.medicalsystem.domain.model.PatientHistoric;
import com.hospital.medicalsystem.domain.service.PatientHistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient-historic")
@RequiredArgsConstructor
public class PatientHistoricResource {

    private final PatientHistoricService patientHistoricService;

    @GetMapping("/{id}")
    public PatientHistoric findPatientHistoric(@PathVariable String id) {

        return patientHistoricService.findPatientHistoric(id);
    }

}