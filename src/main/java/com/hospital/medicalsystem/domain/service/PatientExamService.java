package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.api.assembler.PatientAssembler;
import com.hospital.medicalsystem.api.assembler.PatientExamRegistredAssembler;
import com.hospital.medicalsystem.api.assembler.PatientExamRegistredDisassembler;
import com.hospital.medicalsystem.api.model.PatientExamRegistredModel;
import com.hospital.medicalsystem.api.model.input.ExamRegistredInput;
import com.hospital.medicalsystem.api.model.input.PatientHistoricReferenceInput;
import com.hospital.medicalsystem.domain.exception.EntityConflictException;
import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.Exam;
import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.model.Worker;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import com.hospital.medicalsystem.domain.repository.PatientHistoricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientExamService {

    private final static String WORKER_IS_NOT_DEPARTMENT = "Worker %s is not this department!";

    private final PatientService patientService;
    private final ExamService examService;
    private final ExamRegistredService examRegistredService;
    private final WorkerService workerService;
    private final PatientHistoricService patientHistoricService;

    private final ExamRegistredRepository examRegistredRepository;
    private final PatientHistoricRepository patientHistoricRepository;

    private final PatientExamRegistredDisassembler examRegistredDisassembler;
    private final PatientExamRegistredAssembler examRegistredAssembler;
    private final PatientAssembler patientAssembler;

    public PatientExamRegistredModel startExam(ExamRegistredInput examRegistredInput) {
         var patient = patientService.findByPatientId(examRegistredInput.getPatient().getId());
         var patientHistory = patientHistoricRepository.findHospitalizedByPatientId(patient.getId());

        if (patientHistory == null) {
            throw new EntityNotFoundException(String.format("Paciente %s não está internado!", patient.getName()));
        }

        boolean examActive = examRegistredService.existsActiveExamByPatientAndExamId(patientHistory.getId(), examRegistredInput.getExam().getId());
        if (examActive) {
            throw new EntityConflictException(String.format("O paciente %s já está com um pedido do mesmo exame", patient.getName()));
        }

        Exam exam = examService.findByExamId(examRegistredInput.getExam().getId());
        Worker worker = workerService.findWorkerById(examRegistredInput.getWorker().getId());
        if (!worker.getOccupation().getDepartment().getId().equals(exam.getDepartment().getId())) {
            throw new EntityConflictException(String.format(WORKER_IS_NOT_DEPARTMENT, worker.getName()));
        }

        examRegistredInput.setStartTime(OffsetDateTime.now());

        examRegistredInput.setPatientHistory(new PatientHistoricReferenceInput());
        examRegistredInput.getPatientHistory().setId(patientHistory.getId());

        ExamRegistred examRegistred = examRegistredRepository.save(examRegistredDisassembler.toModel(examRegistredInput));

        examRegistred.setExam(exam);
        examRegistred.setWorker(worker);

        var patientExamRegistredModel = new PatientExamRegistredModel();
        patientExamRegistredModel.setPatient(patientAssembler.toModel(patient));
        patientExamRegistredModel.setExamRegistred(examRegistredAssembler.toModel(examRegistred).getExamRegistred());

        return patientExamRegistredModel;
    }

    public ExamRegistred finishExam(Long patientId, Long examId) {
        var patient = patientService.findByPatientId(patientId);
        var patientHistory = patientHistoricRepository.findHospitalizedByPatientId(patient.getId());
        ExamRegistred activeExam = examRegistredService.findActiveExam(patientHistory.getId(), examId);

        activeExam.setEndTime(OffsetDateTime.now());
        return examRegistredRepository.save(activeExam);
    }

    public List<ExamRegistred> findPatientActiveExamList(Long patientId) {
        var patient = patientService.findByPatientId(patientId);

//        TODO Verificar se o paciente está HOSPITALIZED
        var patientHospitalized = patientHistoricRepository.findHospitalizedByPatientId(patient.getId());
        if (patientHospitalized == null) {
            throw new EntityConflictException(String.format("O paciente %s não está internado!", patient.getName()));
        }

//        TODO Verificar se existe exames para fazer e retornar caso tenha
        var examsActive = examRegistredRepository.findActiveExamListByPatientId(patientHospitalized.getId());
        if (examsActive.isEmpty()) {
            throw new EntityNotFoundException(String.format("O paciente %s não tem exames a serem feitos!", patient.getName()));
        }

        return examsActive;
    }

}
