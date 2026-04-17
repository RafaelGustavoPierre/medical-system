package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.model.HealthInsurance;
import com.hospital.medicalsystem.V2.domain.repository.HealthInsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthInsuranceService {

    private final HealthInsuranceRepository healthInsuranceRepository;

    public HealthInsurance findHealthInsuranceById(Long id) {
        return healthInsuranceRepository.findById(id).orElse(null);
    }

}
