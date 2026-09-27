package com.huumod.manager.entity;

import com.huumod.manager.convert.EncryptConvertor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Convert(converter = EncryptConvertor.class)
    String fullName;

    @Convert(converter = EncryptConvertor.class)
    String gender;

    @Convert(converter = EncryptConvertor.class)
    String address;

    @Convert(converter = EncryptConvertor.class)
    String phone;

    LocalDate dateOfBirth;
}
