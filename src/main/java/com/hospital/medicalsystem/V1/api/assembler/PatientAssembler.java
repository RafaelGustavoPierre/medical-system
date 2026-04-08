package com.hospital.medicalsystem.V1.api.assembler;

import com.hospital.medicalsystem.V1.api.model.PatientModel;
import com.hospital.medicalsystem.V1.domain.model.Patient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientAssembler {

    private final ModelMapper modelMapper;

    public PatientModel toModel(Patient patient) {
        return modelMapper.map(patient, PatientModel.class);
    }

}
