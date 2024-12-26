package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.PatientRecord;
import com.hospital.medicalsystem.domain.repository.PatientRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientRecordService {

    private static final String REGISTERED_NOT_FOUND = "Patient %s record not found!";

    private final PatientRecordRepository patientRecordRepository;

    public PatientRecord findPatientByRecord(Long id) {
        var record = patientRecordRepository.findByPatientId(id);
        if (record == null)
            throw new EntityNotFoundException(String.format(REGISTERED_NOT_FOUND, id));

        return record;
    }

}
