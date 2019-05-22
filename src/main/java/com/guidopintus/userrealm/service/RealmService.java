package com.guidopintus.userrealm.service;

import com.guidopintus.userrealm.dto.AddRealmDTO;
import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RealmService implements GetRealm,CreateRealm {
    @Override
    public RealmDTO get(Integer id) throws RealmNotFoundException {
        return new RealmDTO(1234,"realmName","realmDescription","key");
    }

    @Override
    public RealmDTO create(AddRealmDTO addRealmDTO) throws RealmException {
        return new RealmDTO(1234,"realmName","realmDescription","key");
    }
}
