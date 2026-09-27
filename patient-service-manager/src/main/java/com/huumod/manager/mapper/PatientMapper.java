package com.huumod.manager.mapper;

import com.huumod.manager.dto.request.PatientRequest;
import com.huumod.manager.dto.request.PatientUpdateRequest;
import com.huumod.manager.dto.response.PatientResponse;
import com.huumod.manager.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toPatient(PatientRequest request);
    PatientResponse toPatientResponse(Patient patient);
    void updatePatient(@MappingTarget Patient patient, PatientUpdateRequest request);
}
