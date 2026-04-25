package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.Worker;
import com.hospital.medicalsystem.V2.domain.repository.WorkerHealthInsuranceRepository;
import com.hospital.medicalsystem.V2.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final HealthInsuranceService healthInsuranceService;

    private final WorkerRepository workerRepository;
    private final WorkerHealthInsuranceRepository workerHealthInsuranceRepository;

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException(String.format("Funcionário de ID: %s não foi encontrado", id)));
    }

    public List<Worker> findWorkersByHealthInsurance(Long healthInsuranceId) {
        healthInsuranceService.findHealthInsuranceById(healthInsuranceId);

        return workerHealthInsuranceRepository.findWorkersByHealthInsuranceId(healthInsuranceId);
    }

}
