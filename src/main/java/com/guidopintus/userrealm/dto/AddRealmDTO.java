package com.guidopintus.userrealm.dto;

public class AddRealmDTO {

    private final String name;
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
