package com.hospital.medicalsystem.api.assembler;

import com.hospital.medicalsystem.api.model.PatientHistoryModel;
import com.hospital.medicalsystem.domain.model.PatientHistory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientHistoricAssembler {

    private final ModelMapper modelMapper;

    public PatientHistoryModel toModel(PatientHistory patientHistory) {
        return modelMapper.map(patientHistory, PatientHistoryModel.class);
    }

}
