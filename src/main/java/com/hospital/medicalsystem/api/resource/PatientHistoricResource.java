package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.assembler.MedicalRecordAssembler;
import com.hospital.medicalsystem.api.model.MedicalRecordModel;
import com.hospital.medicalsystem.domain.service.PatientHistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient-historic")
@RequiredArgsConstructor
public class PatientHistoricResource {

    private final PatientHistoricService patientHistoricService;
    private final MedicalRecordAssembler medicalRecordAssembler;

    @GetMapping("/{id}")
    public MedicalRecordModel findPatientHistoric(@PathVariable Long id) {
        return medicalRecordAssembler.toModel(patientHistoricService.findPatientHistoric(id));
    }

}
