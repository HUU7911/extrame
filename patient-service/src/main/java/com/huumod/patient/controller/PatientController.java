package com.huumod.patient.controller;

import com.huumod.patient.dto.response.HelloResponse;
import com.huumod.patient.dto.response.InforResponse;
import com.huumod.patient.service.PatientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PatientController {

    PatientService patientService;

    @GetMapping("/hello")
    public HelloResponse hello() {
        return patientService.restApi();
    }

    @GetMapping("/infor")
    public InforResponse infor() {
        return patientService.inforResponse();
    }
}
