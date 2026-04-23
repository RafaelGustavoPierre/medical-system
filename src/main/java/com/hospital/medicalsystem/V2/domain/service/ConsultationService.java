package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.api.model.input.ConsultationInput;
import com.hospital.medicalsystem.V2.domain.model.*;
import com.hospital.medicalsystem.V2.domain.repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static com.hospital.medicalsystem.V2.domain.model.ConsultationReferences.DOCTOR;
import static com.hospital.medicalsystem.V2.domain.model.ConsultationReferences.NURSE;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final HealthInsuranceService healthInsuranceService;
    private final PatientService patientService;
    private final WorkerService workerService;

    private final ConsultationRepository consultationRepository;

    public Consultation saveConsultation(ConsultationInput input) {
        Patient patient = patientService.findPatientByCpf(input.getPatient().getCpf());

        Worker worker = workerService.findWorkerById(input.getWorker().getId());

        resolveDepartmentCorrect(worker);

        HealthInsurance healthInsurance = healthInsuranceService.findHealthInsuranceById(input.getHealthInsurance().getId());

        Consultation consultation = new Consultation();
        consultation.setWorker(worker);
        consultation.setPatient(patient);
        consultation.setHealthInsurance(healthInsurance);
        consultation.setPrice(BigDecimal.valueOf(10));
        consultation.setDateRegistration(OffsetDateTime.now());

        return consultationRepository.save(consultation);
    }

    private static void resolveDepartmentCorrect(Worker worker) {
        if (!worker.getOccupation().getDepartment().getId().equals(DOCTOR.getDepartmentId()) ||
                !worker.getOccupation().getDepartment().getId().equals(NURSE.getDepartmentId())) {
            System.out.println("O Profissional selecionado não é capacitado para esta função");
        }
    }

}
