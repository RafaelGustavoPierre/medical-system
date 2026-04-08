package com.hospital.medicalsystem.V1.api.resource;

import com.hospital.medicalsystem.V1.api.assembler.MedicalRecordAssembler;
import com.hospital.medicalsystem.V1.api.model.MedicalRecordModel;
import com.hospital.medicalsystem.V1.domain.service.PatientHistoricService;
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
