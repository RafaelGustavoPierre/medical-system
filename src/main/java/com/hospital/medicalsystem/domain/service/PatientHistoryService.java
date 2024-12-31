package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.model.*;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.PatientHistoryRepository;
import com.hospital.medicalsystem.domain.repository.RemedieRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientHistoryService {

    private final PatientService patientService;
    private final PatientRecordService patientRecordService;

    private final ExamRegistredRepository examRegistredRepository;
    private final RemedieRegistredRepository remedieRegistredRepository;
    private final PatientHistoryRepository patientHistoryRepository;

    public MedicalRecord findPatientHistory(Long id) {
        Patient patient = patientService.findByPatientId(id);

        List<PatientHistory> patientHistoryList = patientHistoryRepository.findByPatientId(patient.getId());

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setHospitalizationHistory(new ArrayList<>());

        patientHistoryList.forEach(patientHistory -> {
            var hospitalization = new HospitalizationHistory();

            List<ExamRegistred> examRegistred = examRegistredRepository.findByPatientHistoryId(patientHistory.getId());
            if (!examRegistred.isEmpty()) {
                hospitalization.setExamRegistred(examRegistred);
            }
            List<RemedieRegistred> remedieRegistred = remedieRegistredRepository.findByPatientHistoryId(patientHistory.getId());
            if (!remedieRegistred.isEmpty()) {
                hospitalization.setRemedieRegistred(remedieRegistred);
            }
            var patientRecord = patientRecordService.findPatientByRecord(patientHistory.getId());

            hospitalization.setPatientRecord(patientRecord);
            hospitalization.setPatientHistory(patientHistory);
            medicalRecord.getHospitalizationHistory().add(hospitalization);
        });

        return medicalRecord;
    }

}