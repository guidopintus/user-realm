package com.guidopintus.userrealm.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.Id;

@JacksonXmlRootElement(localName="realm")
public class RealmDTO {



    @JacksonXmlProperty(isAttribute = true)
    private final Integer id;
    @JacksonXmlProperty(isAttribute = true)
    private final String name;
    @JacksonXmlProperty
    private final String description;
    @JacksonXmlProperty
    private final String key;


    public RealmDTO(Integer id, String name, String description, String key) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }
}
