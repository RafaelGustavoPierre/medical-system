package com.hospital.medicalsystem.V1.api.assembler;

import com.hospital.medicalsystem.V1.api.model.input.PatientHistoricInput;
import com.hospital.medicalsystem.V1.domain.model.PatientHistoric;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientHistoricDisassembler {

    private final ModelMapper modelMapper;

    public PatientHistoric toModel(PatientHistoricInput patientHistoricInput) {
        return modelMapper.map(patientHistoricInput, PatientHistoric.class);
    }

}
