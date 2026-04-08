package com.hospital.medicalsystem.V1.api.assembler;

import com.hospital.medicalsystem.V1.api.model.PatientExamRegistredModel;
import com.hospital.medicalsystem.V1.domain.model.ExamRegistred;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientExamRegistredAssembler {

    private final ModelMapper modelMapper;

    public PatientExamRegistredModel toModel(ExamRegistred examRegistred) {
        return modelMapper.map(examRegistred, PatientExamRegistredModel.class);
    }

}
