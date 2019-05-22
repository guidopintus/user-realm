package com.guidopintus.userrealm.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "error")
public class ErrorDTO {

    @JacksonXmlProperty
    private final String code;

    public ErrorDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
