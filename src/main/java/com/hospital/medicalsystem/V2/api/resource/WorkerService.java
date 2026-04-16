package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.Worker;
import com.hospital.medicalsystem.V2.domain.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException(String.format("Funcionário de ID: %s não foi encontrado", id)));
    }

}
