package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.core.utils.UtilsProperties;
import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.PatientHistoricRepository;
import com.hospital.medicalsystem.domain.repository.PatientRecordRepository;
import com.hospital.medicalsystem.domain.repository.RemedieRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final UtilsProperties utilsProperties;

    private final PatientService patientService;
    private final SendEmailService emailService;

    private final PatientRecordRepository patientRecordRepository;
    private final PatientHistoricRepository patientHistoricRepository;
    private final RemedieRegistredRepository remedieRegistredRepository;
    private final ExamRegistredRepository examRegistredRepository;

    public void sendRecordToPatient(Long patientId) {
        var patient = patientService.findByPatientId(patientId);

        var historic = patientHistoricRepository.findLatestByPatientId(patient.getId());
        if (historic == null) {
            throw new EntityNotFoundException(String.format("O Paciente %s não tem histórico médico", patient.getName()));
        }

        var recordPatient = patientRecordRepository.findByPatientHistoricId(historic.getId());
        var remedies = remedieRegistredRepository.findByPatientHistoricId(historic.getId());
        var exams = examRegistredRepository.findByPatientHistoricId(historic.getId());

        String img = this.utilsProperties.getProfileImage();

        var message = SendEmailService.Message.builder()
                .title("Prontuário de " + patient.getName())
                .body("template-email.html")
                .var("patient", patient)
                .var("historic", historic)
                .var("remedies", remedies)
                .var("exams", exams)
                .var("recordPatient", recordPatient)
                .var("img", img)
                .recipient(historic.getPatient().getEmail())
                .build();

        emailService.send(message);
    }

}
