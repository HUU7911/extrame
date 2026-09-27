package com.huumod.manager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponse {

    String id;

    String fullName;

    LocalDate dateOfBirth;

    String gender;

    String phone;

    String address;
}
