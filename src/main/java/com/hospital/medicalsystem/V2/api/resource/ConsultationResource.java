package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.model.input.ConsultationInput;
import com.hospital.medicalsystem.V2.domain.model.Consultation;
import com.hospital.medicalsystem.V2.domain.service.ConsultationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/consultation")
@RequiredArgsConstructor
public class ConsultationResource {

    private final ConsultationService consultationService;

    @PostMapping
    public Consultation saveConsultation(@RequestBody @Valid ConsultationInput input) {
        return consultationService.saveConsultation(input);
    }

}
