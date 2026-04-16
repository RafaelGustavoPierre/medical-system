package com.hospital.medicalsystem.V2.api.resource;

import com.hospital.medicalsystem.V2.api.model.input.ExamRegistredReferenceInput;
import com.hospital.medicalsystem.V2.domain.model.ExamRegistred;
import com.hospital.medicalsystem.V2.domain.service.ExamRegistredService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/exam")
@RequiredArgsConstructor
public class ExamResource {

    private final ExamRegistredService examRegistredService;

    @PostMapping("/schedule")
    public ExamRegistred scheduleExam(@RequestBody @Valid ExamRegistredReferenceInput scheduleExam)  {
        return examRegistredService.scheduleExam(scheduleExam);
    }

}
