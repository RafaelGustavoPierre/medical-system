package com.hospital.medicalsystem.V2.api.assembler;

import com.hospital.medicalsystem.V2.api.model.PatientResumeModel;
import com.hospital.medicalsystem.V2.domain.model.Patient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientResumeAssembler {

    private final ModelMapper modelMapper;

    public PatientResumeModel toModel(Patient patient) { return modelMapper.map(patient, PatientResumeModel.class); }

}
