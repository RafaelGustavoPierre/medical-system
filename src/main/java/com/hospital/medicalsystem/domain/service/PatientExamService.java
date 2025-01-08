package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.api.assembler.PatientAssembler;
import com.hospital.medicalsystem.api.assembler.PatientExamRegistredAssembler;
import com.hospital.medicalsystem.api.assembler.PatientExamRegistredDisassembler;
import com.hospital.medicalsystem.api.model.PatientExamRegistredModel;
import com.hospital.medicalsystem.api.model.input.ExamRegistredInput;
import com.hospital.medicalsystem.api.model.input.PatientHistoryReferenceInput;
import com.hospital.medicalsystem.domain.exception.EntityConflictException;
import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.Exam;
import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.model.Patient;
import com.hospital.medicalsystem.domain.model.Worker;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PatientExamService {

    private final static String ACTIVE_EXAM_NOT_FOUND = "No active exam found";
    private final static String WORKER_IS_NOT_DEPARTMENT = "Worker %s is not this department!";

    private final PatientService patientService;
    private final ExamService examService;
    private final ExamRegistredService examRegistredService;
    private final WorkerService workerService;
    private final PatientHistoryService patientHistoryService;

    private final ExamRegistredRepository examRegistredRepository;

    private final PatientExamRegistredDisassembler examRegistredDisassembler;
    private final PatientExamRegistredAssembler examRegistredAssembler;
    private final PatientAssembler patientAssembler;

    public PatientExamRegistredModel startExam(ExamRegistredInput examRegistredInput) {
         var patient = patientService.findByPatientId(examRegistredInput.getPatient().getId());
         var patientHistory = patientHistoryService.findPatientHistory(patient.getId());

        if (!patientHistory.getHospitalizationHistory().getFirst().getPatientHistory().getStatus().equals("HOSPITALIZED")) {
            throw new EntityNotFoundException(String.format("Paciente %s não está internado!", patient.getName()));
        }

        boolean examActive = examRegistredService.existsActiveExamByPatientAndExamId(patient.getId(), examRegistredInput.getExam().getId());
        if (examActive) {
            throw new EntityConflictException(String.format("O paciente %s já está com um pedido do mesmo exame", patient.getName()));
        }

        Exam exam = examService.findByExamId(examRegistredInput.getExam().getId());
        Worker worker = workerService.findWorkerById(examRegistredInput.getWorker().getId());
        if (!worker.getOccupation().getDepartment().getId().equals(exam.getDepartment().getId())) {
            throw new EntityConflictException(String.format(WORKER_IS_NOT_DEPARTMENT, worker.getName()));
        }

        examRegistredInput.setStartTime(OffsetDateTime.now());

        examRegistredInput.setPatientHistory(new PatientHistoryReferenceInput());
        examRegistredInput.getPatientHistory().setId(patient.getId());

        ExamRegistred examRegistred = examRegistredRepository.save(examRegistredDisassembler.toModel(examRegistredInput));

        examRegistred.setExam(exam);
        examRegistred.setWorker(worker);

        var patientExamRegistredModel = new PatientExamRegistredModel();
        patientExamRegistredModel.setPatient(patientAssembler.toModel(patient));
        patientExamRegistredModel.setExamRegistred(examRegistredAssembler.toModel(examRegistred).getExamRegistred());

        return patientExamRegistredModel;
    }

    public ExamRegistred finishExam(Long patientId) {
        Patient patient = patientService.findByPatientId(patientId);
        ExamRegistred activeExam = examRegistredService.findActiveExam(patient.getId());
        if (activeExam == null) {
            throw new EntityNotFoundException(ACTIVE_EXAM_NOT_FOUND);
        }

        activeExam.setEndTime(OffsetDateTime.now());
        return examRegistredRepository.save(activeExam);
    }

}
