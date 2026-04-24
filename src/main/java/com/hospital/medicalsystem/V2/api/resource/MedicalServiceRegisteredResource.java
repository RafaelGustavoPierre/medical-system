package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.model.input.MedicalServiceRegistredReferenceInput;
import com.hospital.medicalsystem.V2.domain.model.MedicalServiceRegistered;
import com.hospital.medicalsystem.V2.domain.service.MedicalServiceRegisteredService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/medical-service-registred")
@RequiredArgsConstructor
public class MedicalServiceRegisteredResource {

    private final MedicalServiceRegisteredService medicalServiceRegisteredService;

    @PostMapping("/schedule")
    public MedicalServiceRegistered scheduleExam(@RequestBody @Valid MedicalServiceRegistredReferenceInput scheduleExam)  {
        return medicalServiceRegisteredService.scheduleExam(scheduleExam);
    }

    @GetMapping("/{examId}")
    public MedicalServiceRegistered findExamRegisteredById(@PathVariable Long examId) {
        return medicalServiceRegisteredService.findExamRegisteredById(examId);
    }

}
