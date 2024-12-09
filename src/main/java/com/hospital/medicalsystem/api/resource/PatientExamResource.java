package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.assembler.PatientExamRegistredAssembler;
import com.hospital.medicalsystem.api.model.PatientExamRegistredModel;
import com.hospital.medicalsystem.domain.service.PatientExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient-exam")
@RequiredArgsConstructor
public class PatientExamResource {

    private final PatientExamService patientExamService;

    private final PatientExamRegistredAssembler patientExamRegistredAssembler;

    @PutMapping("/finish-exam/{patientId}")
    public PatientExamRegistredModel finishExame(@PathVariable String patientId) {
        return patientExamRegistredAssembler.toModel(patientExamService.finishExam(patientId));
    }

}
