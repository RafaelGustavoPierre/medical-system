package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.api.assembler.PatientExamRegistredAssembler;
import com.hospital.medicalsystem.api.model.PatientExamRegistredModel;
import com.hospital.medicalsystem.api.model.input.ExamRegistredInput;
import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.service.PatientExamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-exam")
@RequiredArgsConstructor
public class PatientExamResource {

    private final PatientExamService patientExamService;

    private final PatientExamRegistredAssembler patientExamRegistredAssembler;

    @PostMapping("/start-exam")
    public PatientExamRegistredModel startExam(@Valid @RequestBody ExamRegistredInput examRegistredInput) {
        return patientExamService.startExam(examRegistredInput);
    }

    @PutMapping("/finish-exam/patient/{patientId}/exam/{examId}")
    public PatientExamRegistredModel finishExame(@PathVariable Long patientId, @PathVariable Long examId) {
        return patientExamRegistredAssembler.toModel(patientExamService.finishExam(patientId, examId));
    }

    @GetMapping("/exam-active/{patientId}")
    public List<ExamRegistred> PatientActiveExamList(@PathVariable Long patientId) {
        return patientExamService.findPatientActiveExamList(patientId);
    }

}
