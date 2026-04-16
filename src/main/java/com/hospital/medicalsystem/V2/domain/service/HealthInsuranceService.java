package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurance;
import com.hospital.medicalsystem.V2.domain.repository.HealthInsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthInsuranceService {

    private final HealthInsuranceRepository healthInsuranceRepository;

    public HealthInsurance findHealthInsuranceById(Long id) {
        return healthInsuranceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format("Convênio de ID: %s não foi encontrado", id)));
    }

}
