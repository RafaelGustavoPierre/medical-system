package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.api.assembler.PatientAssembler;
import com.hospital.medicalsystem.api.assembler.PatientHistoricAssembler;
import com.hospital.medicalsystem.api.assembler.PatientHistoricDisassembler;
import com.hospital.medicalsystem.api.model.PatientAdmission;
import com.hospital.medicalsystem.api.model.input.PatientHistoricInput;
import com.hospital.medicalsystem.api.model.input.PatientReferenceInput;
import com.hospital.medicalsystem.api.model.input.WorkerReferenceInput;
import com.hospital.medicalsystem.domain.exception.EntityConflictException;
import com.hospital.medicalsystem.domain.model.*;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.PatientHistoricRepository;
import com.hospital.medicalsystem.domain.repository.RemedieRegistredRepository;
import com.hospital.medicalsystem.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
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
    private final WorkerRepository workerRepository;

    private final PatientHistoricDisassembler patientHistoricDisassembler;
    private final PatientHistoricAssembler patientHistoricAssembler;
    private final PatientAssembler patientAssembler;

    public MedicalRecord findPatientHistoric(Long id) {
        Patient patient = patientService.findByPatientId(id);

        List<PatientHistoric> patientHistoricList = patientHistoricRepository.findListByPatientId(patient.getId());

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

    public PatientAdmission admitPatient(Long id) {
        var patient = patientService.findByPatientId(id);

        boolean patientIsHopitalized = patientHistoricRepository.existsActiveAdmissionByPatientId(patient.getId());
        if (patientIsHopitalized) {
            throw new EntityConflictException(String.format("O Paciente %s - %s já está internado!", patient.getId(), patient.getName()));
        }

        PatientHistoricInput patientHistoricInput = new PatientHistoricInput();
        patientHistoricInput.setPatient(new PatientReferenceInput());
        patientHistoricInput.getPatient().setId(patient.getId());
        patientHistoricInput.setDateAdmission(OffsetDateTime.now());
        patientHistoricInput.setStatus("HOSPITALIZED");

        Worker worker = workerRepository.findRandomDoctors();
        patientHistoricInput.setWorker(new WorkerReferenceInput());
        patientHistoricInput.getWorker().setId(worker.getId());

        var patientHistoricDomain = patientHistoricDisassembler.toModel(patientHistoricInput);
        patientHistoricRepository.save(patientHistoricDomain);

        var admitPatient = patientHistoricRepository.findHospitalizedByPatientId(patient.getId());
        admitPatient.setWorker(worker);

        var patientHistoricModel = patientHistoricAssembler.toModel(admitPatient);
        var patientModel = patientAssembler.toModel(patient);

        PatientAdmission patientAdmission = new PatientAdmission();
        patientAdmission.setPatient(patientModel);
        patientAdmission.setPatientHistoric(patientHistoricModel);

        return patientAdmission;
    }

}