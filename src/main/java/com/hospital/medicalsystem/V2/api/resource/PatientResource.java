package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.assembler.PatientResumeAssembler;
import com.hospital.medicalsystem.V2.api.model.PatientResumeModel;
import com.hospital.medicalsystem.V2.domain.model.Patient;
import com.hospital.medicalsystem.V2.domain.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/patients")
@RequiredArgsConstructor
public class PatientResource {

    private final PatientService patientService;

    private final PatientResumeAssembler patientResumeAssembler;

    @GetMapping("/{cpf}")
    public Patient findPatientByCpf(@PathVariable String cpf) {
        return patientService.findPatientByCpf(cpf);
    }

    @GetMapping("/resume/{cpf}")
    public PatientResumeModel findPatientResumeByCpf(@PathVariable String cpf) {
        return patientResumeAssembler.toModel(patientService.findPatientByCpf(cpf));
    }

}
