package com.hospital.medicalsystem.api.resource;

import com.hospital.medicalsystem.domain.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailResource {

    private final EmailService emailService;

    @PostMapping("/{patientId}")
    public void sendRecordToPatient(@PathVariable Long patientId) {
        emailService.sendRecordToPatient(patientId);
    }

}
