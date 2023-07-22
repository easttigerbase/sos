package com.ssoptimus.sos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
public enum CommonResponse {

    SUCCESS(200,"OK"),
    FAIL(-1,"FAIL");

    private int code;
    private String message;

    CommonResponse(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
