package com.huumod.manager.controller;

import com.huumod.manager.dto.ApiResponse;
import com.huumod.manager.dto.request.PatientRequest;
import com.huumod.manager.dto.request.PatientUpdateRequest;
import com.huumod.manager.dto.response.PatientResponse;
import com.huumod.manager.service.PatientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PatientController {

    PatientService patientService;

    @PostMapping
    ApiResponse<PatientResponse> createPatient(@RequestBody PatientRequest patientRequest) {
        return ApiResponse.<PatientResponse>builder()
                .results(patientService.createPatient(patientRequest))
                .build();
    }

    @GetMapping("{Id}")
    ApiResponse<PatientResponse> getPatientById(@PathVariable String Id) {
        return ApiResponse.<PatientResponse>builder()
                .results(patientService.getPatientById(Id))
                .build();
    }

    @PutMapping("{Id}")
    ApiResponse<PatientResponse> updatePatientById(@PathVariable String Id,
                                                   @RequestBody PatientUpdateRequest request) {
        return ApiResponse.<PatientResponse>builder()
                .results(patientService.updatePatient(Id, request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PatientResponse>> getAllPatients() {
        return ApiResponse.<List<PatientResponse>>builder()
                .results(patientService.getPatients())
                .build();
    }

    @DeleteMapping("{Id}")
    ApiResponse<Void> deletePatientById(@PathVariable String Id) {
        patientService.deletePatientById(Id);
        return ApiResponse.<Void>builder()
                .message("Patient deleted successfully")
                .build();
    }
}
