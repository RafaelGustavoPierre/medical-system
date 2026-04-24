package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.api.model.input.MedicalServiceRegistredReferenceInput;
import com.hospital.medicalsystem.V2.domain.exception.ConflictException;
import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.*;
import com.hospital.medicalsystem.V2.domain.repository.MedicalServiceRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static com.hospital.medicalsystem.V2.domain.model.HealthInsuranceType.*;

@Service
@RequiredArgsConstructor
public class MedicalServiceRegisteredService {

    private final PatientService patientService;
    private final WorkerService workerService;
    private final MedicalServiceService medicalServiceService;
    private final HealthInsuranceService healthInsuranceService;

    private final MedicalServiceRegistredRepository medicalServiceRegistredRepository;

    public MedicalServiceRegistered scheduleExam(MedicalServiceRegistredReferenceInput scheduleExam) {
        Patient patient = patientService.findPatientByCpf(scheduleExam.getPatient().getCpf());

        Worker worker = workerService.findWorkerById(scheduleExam.getWorker().getId());

        MedicalService medicalService = medicalServiceService.findExamById(scheduleExam.getMedicalService().getId());

        validateWorkerCanPerformExam(worker, medicalService);

        HealthInsurance healthInsurance = healthInsuranceService.resolveHealthInsurance(patient, scheduleExam);

        BigDecimal price = this.resolvePrice(medicalService, healthInsurance);

        MedicalServiceRegistered medicalServiceRegistered = MedicalServiceRegistered.builder()
                .patient(patient)
                .worker(worker)
                .medicalService(medicalService)
                .price(price)
                .startTime(OffsetDateTime.now())
                .healthInsurance(healthInsurance)
                .build();

        return medicalServiceRegistredRepository.save(medicalServiceRegistered);
    }

    public MedicalServiceRegistered findExamRegisteredById(Long examId) {
        return medicalServiceRegistredRepository.findById(examId).orElseThrow(() -> new EntityNotFoundException(
                String.format("O Exame de ID %s não foi encontrado", examId)));
    }



    private BigDecimal resolvePrice(MedicalService medicalService, HealthInsurance healthInsurance) {
        return healthInsurance.getName().equals(PRIVATE.getName()) ? medicalService.getPrice() : BigDecimal.ZERO;
    }

    private void validateWorkerCanPerformExam(Worker worker, MedicalService medicalService) {
        if (!worker.getOccupation().getDepartment().equals(medicalService.getDepartment())) {
            throw new ConflictException(String.format("O técnico %s não está habilitado para realizar o exame %s",
                    worker.getName(), medicalService.getName()));
        }
    }

}