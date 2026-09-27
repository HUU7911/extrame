package com.huumod.manager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    PATIENT_NOT_FOUND(404, "patient not found");

    private int code;
    private String message;
}
