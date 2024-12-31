package com.hospital.medicalsystem.api.assembler;

import com.hospital.medicalsystem.api.model.MedicalRecordModel;
import com.hospital.medicalsystem.domain.model.MedicalRecord;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicalRecordAssembler {

    private final ModelMapper modelMapper;

    public MedicalRecordModel toModel(MedicalRecord medicalRecord) {
        return modelMapper.map(medicalRecord, MedicalRecordModel.class);
    }

}
