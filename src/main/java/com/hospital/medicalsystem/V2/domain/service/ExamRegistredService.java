package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.api.model.input.ExamRegistredReferenceInput;
import com.hospital.medicalsystem.V2.api.resource.WorkerService;
import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.ExamRegistred;
import com.hospital.medicalsystem.V2.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class ExamRegistredService {

    private final PatientService patientService;
    private final WorkerService workerService;
    private final ExamService examService;
    private final HealthInsuranceService healthInsuranceService;
    private final HealthInsurancePatientService healthInsurancePatientService;

    private final ExamRegistredRepository examRegistredRepository;

    public ExamRegistred scheduleExam(ExamRegistredReferenceInput scheduleExam) {
        var patient = patientService.findPatientByCpf(scheduleExam.getPatient().getCpf());

        var worker = workerService.findWorkerById(scheduleExam.getWorker().getId());
        var exam = examService.findExamById(scheduleExam.getExam().getId());

        if (!worker.getOccupation().getDepartment().equals(exam.getDepartment())) {
            throw new EntityNotFoundException(String.format("O Técnico %s não faz este exame", worker.getName()));
        }

        var registerExam = new ExamRegistred();
        if (scheduleExam.getHealthInsurance().getId() != null) {
            var patientWithHealthInsurance = healthInsurancePatientService.findByPatientIdAndHealthInsuranceId(patient.getId(), scheduleExam.getHealthInsurance().getId());

            if (patientWithHealthInsurance.getHealthInsurance().getId() != 1) {
                registerExam.setPrice(BigDecimal.ZERO);
                registerExam.setHealthInsurance(patientWithHealthInsurance.getHealthInsurance());
            } else {
                registerExam.setPrice(exam.getPrice());
                registerExam.setHealthInsurance(healthInsuranceService.findHealthInsuranceById(1L));
            }

            registerExam.setStartTime(OffsetDateTime.now());
            registerExam.setExam(exam);
            registerExam.setWorker(worker);
            registerExam.setPatient(patient);
        }
        return examRegistredRepository.save(registerExam);
    }

}