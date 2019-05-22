package com.guidopintus.userrealm.service;

import org.springframework.stereotype.Service;

@Service("realmKeyGen")
public class RealmKeyGeneratorService implements GenerateKey {
    @Override
    public String getKey() {
        return "realmEncryptedKey";
    }
}
