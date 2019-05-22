package com.guidopintus.userrealm.service;

import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface GetRealm {

    RealmDTO get(Integer id) throws RealmException;

}
