package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.api.model.input.ExamRegistredReferenceInput;
import com.hospital.medicalsystem.V2.domain.exception.ConflictException;
import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.*;
import com.hospital.medicalsystem.V2.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static com.hospital.medicalsystem.V2.domain.model.ExamRegistered.*;

@Service
@RequiredArgsConstructor
public class ExamRegisteredService {

    private final PatientService patientService;
    private final WorkerService workerService;
    private final ExamService examService;
    private final HealthInsuranceService healthInsuranceService;

    private final ExamRegistredRepository examRegistredRepository;

    public ExamRegistred scheduleExam(ExamRegistredReferenceInput scheduleExam) {
        Patient patient = patientService.findPatientByCpf(scheduleExam.getPatient().getCpf());

        Worker worker = workerService.findWorkerById(scheduleExam.getWorker().getId());

        Exam exam = examService.findExamById(scheduleExam.getExam().getId());

        validateWorkerCanPerformExam(worker, exam);

        HealthInsurance healthInsurance = healthInsuranceService.resolveHealthInsurance(patient, scheduleExam);

        BigDecimal price = this.resolvePrice(exam, healthInsurance);

        ExamRegistred examRegistred = ExamRegistred.builder()
                .patient(patient)
                .worker(worker)
                .exam(exam)
                .price(price)
                .startTime(OffsetDateTime.now())
                .healthInsurance(healthInsurance)
                .build();

        return examRegistredRepository.save(examRegistred);
    }

    public ExamRegistred findExamRegisteredById(Long examId) {
        return examRegistredRepository.findById(examId).orElseThrow(() -> new EntityNotFoundException(
                String.format("O Exame de ID %s não foi encontrado", examId)));
    }



    private BigDecimal resolvePrice(Exam exam, HealthInsurance healthInsurance) {
        return healthInsurance.getName().equals(PARTICULAR.getName()) ? exam.getPrice() : BigDecimal.ZERO;
    }

    private void validateWorkerCanPerformExam(Worker worker, Exam exam) {
        if (!worker.getOccupation().getDepartment().equals(exam.getDepartment())) {
            throw new ConflictException(String.format("O técnico %s não está habilitado para realizar o exame %s",
                    worker.getName(), exam.getName()));
        }
    }

}