package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.assembler.MedicalRecordAssembler;
import com.hospital.medicalsystem.api.model.MedicalRecordModel;
import com.hospital.medicalsystem.domain.service.PatientHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient-historic")
@RequiredArgsConstructor
public class PatientHistoricResource {

    private final PatientHistoryService patientHistoricService;
    private final MedicalRecordAssembler medicalRecordAssembler;

    @GetMapping("/{id}")
    public MedicalRecordModel findPatientHistoric(@PathVariable Long id) {
        return medicalRecordAssembler.toModel(patientHistoricService.findPatientHistory(id));
    }

}
