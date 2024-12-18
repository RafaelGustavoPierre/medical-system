package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.Worker;
import com.hospital.medicalsystem.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private static final String WORKER_NOT_FOUND = "Worker ID %s not found!";

    private final WorkerRepository workerRepository;

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format(WORKER_NOT_FOUND, id)));
    }

}
