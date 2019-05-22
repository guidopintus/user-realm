package com.guidopintus.userrealm.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="realm")
public class AddRealmDTO {

    @JacksonXmlProperty(isAttribute = true)
    private final String name;
    @JacksonXmlProperty
    private final String description;

    public AddRealmDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
