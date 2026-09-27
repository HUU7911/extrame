package com.huumod.manager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientUpdateRequest {

    String fullName;

    LocalDate dateOfBirth;

    String gender;

    Long phone;

    String address;
}
