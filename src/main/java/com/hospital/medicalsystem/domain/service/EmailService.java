package com.hospital.medicalsystem.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final PatientService patientService;
    private final SendEmailService emailService;

    public void sendRecordToPatient(Long patientId) {
        var patient = patientService.findByPatientId(patientId);

        var message = SendEmailService.Message.builder()
                .title("Prontuario de " + patient.getName())
                .body("<strong>" + patient.getName() + "</strong>" + " aqui está seu histórico médico!")
                .recipient(patient.getEmail())
                .build();

        emailService.send(message);
    }

}
