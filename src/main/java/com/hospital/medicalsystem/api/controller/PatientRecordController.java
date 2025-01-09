package com.hospital.medicalsystem.api.controller;

import com.hospital.medicalsystem.api.resource.PatientHistoricResource;
import com.hospital.medicalsystem.domain.service.PatientHistoricService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medical-record")
public class PatientRecordController {

    private final PatientHistoricResource patientHistoricResource;

    @GetMapping("/{id}")
    public String patientRecordTemplate(@PathVariable Long id, Model model) {
        var patientRecord = this.patientHistoricResource.findPatientHistoric(id);

        model.addAttribute("patient", patientRecord.getPatient());
        model.addAttribute("hospitalizationHistoric", patientRecord.getHospitalizationHistoric());
        return "pages/patient-record";
    }

}
