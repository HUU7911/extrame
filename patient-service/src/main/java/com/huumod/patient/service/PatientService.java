package com.huumod.patient.service;

import com.huumod.patient.constant.Status;
import com.huumod.patient.dto.response.HelloResponse;
import com.huumod.patient.dto.response.InforResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientService {

    @NonFinal
    @Value("${app.service}")
    String service;

    @NonFinal
    @Value("${app.version}")
    Double version;

    public HelloResponse restApi() {
        return HelloResponse.builder()
                .message("Welcome to Patient Service")
                .build();
    }

    public InforResponse inforResponse() {
        return InforResponse.builder()
                .service(service)
                .version(String.valueOf(version))
                .status(Status.UP)
                .build();
    }
}
