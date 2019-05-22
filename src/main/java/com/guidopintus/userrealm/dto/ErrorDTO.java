package com.guidopintus.userrealm.dto;

public class ErrorDTO {

    private final String code;

    public ErrorDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
