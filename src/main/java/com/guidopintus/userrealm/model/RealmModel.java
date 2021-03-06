package com.guidopintus.userrealm.model;

public class RealmModel {

    private final Integer id;
    private final String name;
    private final String description;
    private final String key;

    public RealmModel(Integer id, String name, String description, String key) {
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
