package com.hospital.medicalsystem.api.controller;

import com.hospital.medicalsystem.domain.service.PatientHistoryService;
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

    private final PatientHistoryService patientHistoricService;

    @GetMapping("/{id}")
    public String patientRecordTemplate(@PathVariable Long id, Model model) {
//        var patientRecord = this.patientHistoricService.findPatientHistoric(id);
//
//        model.addAttribute("patient", patientRecord.getPatient());
//        model.addAttribute("patientRecord", patientRecord.getPatientRecord());
//        model.addAttribute("examRegistred", patientRecord.getExamRegistred());
//        model.addAttribute("remedieRegistred", patientRecord.getRemedieRegistred());
        return "pages/patient-record";
    }

}
