package com.hospital.medicalsystem.V1.api.assembler;

import com.hospital.medicalsystem.V1.api.model.PatientHistoricModel;
import com.hospital.medicalsystem.V1.domain.model.PatientHistoric;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientHistoricAssembler {

    private final ModelMapper modelMapper;

    public PatientHistoricModel toModel(PatientHistoric patientHistoric) {
        return modelMapper.map(patientHistoric, PatientHistoricModel.class);
    }

}
