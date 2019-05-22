package com.guidopintus.userrealm.service;

import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RealmService implements GetRealm,CreateRealm {
    @Override
    public RealmDTO get(Integer id) throws RealmNotFoundException {
        throw new RealmNotFoundException();
    }
}
