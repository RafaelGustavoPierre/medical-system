package com.hospital.medicalsystem.V1.domain.service;

import com.hospital.medicalsystem.V1.domain.exception.EntityNotFoundExceptionV1;
import com.hospital.medicalsystem.V1.domain.model.Worker;
import com.hospital.medicalsystem.V1.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WorkerService {

    private static final String WORKER_NOT_FOUND = "Worker ID %s not found!";

    private final WorkerRepository workerRepository;

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundExceptionV1(String.format(WORKER_NOT_FOUND, id)));
    }

}
