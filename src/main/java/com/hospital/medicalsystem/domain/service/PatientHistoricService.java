package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.model.*;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.RemedieRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientHistoricService {

    private final PatientService patientService;
    private final PatientRecordService patientRecordService;

    private final ExamRegistredRepository examRegistredRepository;
    private final RemedieRegistredRepository remedieRegistredRepository;

    public PatientHistoric findPatientHistoric(Long id) {
        Patient patient = patientService.findByPatientId(id);

        PatientRecord patientRecord = patientRecordService.findPatientByRecord(patient.getId());
        List<ExamRegistred> examRegistred = examRegistredRepository.findByPatientId(patient.getId());
        List<RemedieRegistred> remedieRegistred = remedieRegistredRepository.findByPatientId(patient.getId());

        PatientHistoric patientHistoric = new PatientHistoric();

        patientHistoric.setPatient(patient);
        patientHistoric.setExamRegistred(examRegistred);
        patientHistoric.setRemedieRegistred(remedieRegistred);
        patientHistoric.setPatientRecord(patientRecord);
        return patientHistoric;
    }

}
