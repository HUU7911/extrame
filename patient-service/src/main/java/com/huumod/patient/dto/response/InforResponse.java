package com.huumod.patient.dto.response;

import com.huumod.patient.constant.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InforResponse {
    String service;
    String version;
    Enum<Status> status;
}
