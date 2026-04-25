package com.hospital.medicalsystem.V2.api.assembler;

import com.hospital.medicalsystem.V2.api.model.WorkerModel;
import com.hospital.medicalsystem.V2.domain.model.Worker;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WorkerAssembler {

    private final ModelMapper modelMapper;

    public WorkerModel toModel(Worker worker) {
        return modelMapper.map(worker, WorkerModel.class);
    }

    public List<WorkerModel> toCollectionModel(List<Worker> workers) {
        return workers.stream()
                .map(this::toModel)
                .toList();
    }

}
