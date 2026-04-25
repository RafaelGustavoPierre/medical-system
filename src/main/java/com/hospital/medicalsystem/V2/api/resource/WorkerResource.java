package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.assembler.WorkerAssembler;
import com.hospital.medicalsystem.V2.api.model.WorkerModel;
import com.hospital.medicalsystem.V2.domain.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/workers")
@RequiredArgsConstructor
public class WorkerResource {

    private final WorkerService workerService;

    private final WorkerAssembler workerAssembler;

    @GetMapping("/by-health-insurance/{healthInsuranceId}")
    public List<WorkerModel> findWorkersByHealthInsurance(@PathVariable Long healthInsuranceId) {
        return workerAssembler.toCollectionModel(workerService.findWorkersByHealthInsurance(healthInsuranceId));
    }

}
