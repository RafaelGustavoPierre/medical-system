package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.model.*;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.PatientHistoricRepository;
import com.hospital.medicalsystem.domain.repository.RemedieRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientHistoricService {

    private final PatientService patientService;
    private final PatientRecordService patientRecordService;

    private final ExamRegistredRepository examRegistredRepository;
    private final RemedieRegistredRepository remedieRegistredRepository;
    private final PatientHistoricRepository patientHistoricRepository;

    public MedicalRecord findPatientHistoric(Long id) {
        Patient patient = patientService.findByPatientId(id);

        List<PatientHistoric> patientHistoricList = patientHistoricRepository.findByPatientId(patient.getId());

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setHospitalizationHistoric(new ArrayList<>());

        patientHistoricList.forEach(patientHistoric -> {
            var hospitalization = new HospitalizationHistoric();

            List<ExamRegistred> examRegistred = examRegistredRepository.findByPatientHistoricId(patientHistoric.getId());
            if (!examRegistred.isEmpty()) {
                hospitalization.setExamRegistred(examRegistred);
            }
            List<RemedieRegistred> remedieRegistred = remedieRegistredRepository.findByPatientHistoricId(patientHistoric.getId());
            if (!remedieRegistred.isEmpty()) {
                hospitalization.setRemedieRegistred(remedieRegistred);
            }
            var patientRecord = patientRecordService.findPatientByRecord(patientHistoric.getId());

            hospitalization.setPatientRecord(patientRecord);
            hospitalization.setPatientHistoric(patientHistoric);
            medicalRecord.getHospitalizationHistoric().add(hospitalization);
        });

        return medicalRecord;
    }

}