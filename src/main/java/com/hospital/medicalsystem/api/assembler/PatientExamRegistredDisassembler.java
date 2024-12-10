package com.hospital.medicalsystem.api.assembler;

import com.hospital.medicalsystem.api.model.input.ExamRegistredInput;
import com.hospital.medicalsystem.domain.model.ExamRegistred;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientExamRegistredDisassembler {

    private final ModelMapper modelMapper;

    public ExamRegistred toModel(ExamRegistredInput examRegistredInput) {
        return modelMapper.map(examRegistredInput, ExamRegistred.class);
    }

}
