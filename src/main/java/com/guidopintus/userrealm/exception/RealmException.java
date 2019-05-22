package com.guidopintus.userrealm.exception;

public class RealmException extends Throwable {

    private final String code;


    public RealmException(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
