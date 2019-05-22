package com.guidopintus.userrealm.exception;

public class RealmNotFoundException extends RealmException {
    public RealmNotFoundException() {
        super("RealmNotFound");
    }
}
