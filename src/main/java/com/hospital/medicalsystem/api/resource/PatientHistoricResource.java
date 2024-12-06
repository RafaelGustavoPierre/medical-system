package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.assembler.PatientHistoricAssembler;
import com.hospital.medicalsystem.api.model.PatientHistoricModel;
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
    private final PatientHistoricAssembler patientHistoricAssembler;

    @GetMapping("/{id}")
    public PatientHistoricModel findPatientHistoric(@PathVariable String id) {
        return patientHistoricAssembler.toModel(patientHistoricService.findPatientHistoric(id));
    }

}
