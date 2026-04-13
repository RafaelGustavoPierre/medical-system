package com.hospital.medicalsystem.V1.api.resource;

import com.hospital.medicalsystem.V1.api.model.PatientRegistred;
import com.hospital.medicalsystem.V1.domain.service.PatientHistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("patientResourceV1")
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientResource {

    private final PatientHistoricService patientHistoricService;

    @PostMapping("/{id}/admissions")
    public PatientRegistred admitPatient(@PathVariable Long id) {
        return patientHistoricService.admitPatient(id);
    }

    @PutMapping("/{id}/discharge")
    public PatientRegistred dischargePatient(@PathVariable Long id) {
        return patientHistoricService.dischargePatient(id);
    }

}
