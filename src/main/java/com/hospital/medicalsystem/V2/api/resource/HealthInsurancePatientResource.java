package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.assembler.HealthInsurancePatientAssembler;
import com.hospital.medicalsystem.V2.api.model.HealthInsuranceModel;
import com.hospital.medicalsystem.V2.api.model.HealthInsurancePatientModel;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import com.hospital.medicalsystem.V2.domain.service.HealthInsurancePatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/health-insurance-patient")
public class HealthInsurancePatientResource {

    private final HealthInsurancePatientService healthInsurancePatientService;

    private final HealthInsurancePatientAssembler healthInsurancePatientAssembler;

    @GetMapping("/{patientId}")
    public List<HealthInsurancePatientModel> findPatientListHealthInsurance(@PathVariable Long patientId) {
        return healthInsurancePatientAssembler.toCollectionModel(healthInsurancePatientService.findPatientListHealthInsurance(patientId));
    }

}
