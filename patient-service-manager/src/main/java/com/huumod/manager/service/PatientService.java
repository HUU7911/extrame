package com.huumod.manager.service;

import com.huumod.manager.dto.request.PatientRequest;
import com.huumod.manager.dto.request.PatientUpdateRequest;
import com.huumod.manager.dto.response.PatientResponse;
import com.huumod.manager.exception.AppException;
import com.huumod.manager.exception.ErrorCode;
import com.huumod.manager.mapper.PatientMapper;
import com.huumod.manager.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PatientService {

    PatientMapper patientMapper;
    PatientRepository patientRepository;

    @Transactional
    public PatientResponse createPatient(PatientRequest request) {
        var patient = patientMapper.toPatient(request);

        return patientMapper.toPatientResponse(patientRepository.save(patient));
    }

    @Transactional
    public PatientResponse updatePatient(String Id, PatientUpdateRequest request) {
        var patient = patientRepository.findById(Id).orElseThrow(
                () -> new AppException(ErrorCode.PATIENT_NOT_FOUND)
        );

        patientMapper.updatePatient(patient, request);

        return patientMapper.toPatientResponse(patientRepository.save(patient));
    }

    public PatientResponse getPatientById(String Id) {
        var patient = patientRepository.findById(Id).orElseThrow(
                () -> new AppException(ErrorCode.PATIENT_NOT_FOUND)
        );

        return patientMapper.toPatientResponse(patient);
    }

    public List<PatientResponse> getPatients() {
        return patientRepository
                .findAll().stream()
                .map(patientMapper::toPatientResponse)
                .toList();
    }

    public void deletePatientById(String Id) {
        patientRepository.deleteById(Id);
    }
}
