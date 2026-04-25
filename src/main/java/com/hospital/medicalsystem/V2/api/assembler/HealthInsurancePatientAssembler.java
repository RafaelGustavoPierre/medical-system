package com.hospital.medicalsystem.V2.api.assembler;

import com.hospital.medicalsystem.V2.api.model.HealthInsuranceModel;
import com.hospital.medicalsystem.V2.api.model.HealthInsurancePatientModel;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurance;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class HealthInsurancePatientAssembler {

    private final ModelMapper modelMapper;

    public HealthInsurancePatientModel toModel(HealthInsurancePatient healthInsurance) {
        return modelMapper.map(healthInsurance, HealthInsurancePatientModel.class);
    }

    public List<HealthInsurancePatientModel> toCollectionModel(List<HealthInsurancePatient> healthInsurances) {
        return healthInsurances.stream()
                .map(this::toModel)
                .toList();
    }

}
