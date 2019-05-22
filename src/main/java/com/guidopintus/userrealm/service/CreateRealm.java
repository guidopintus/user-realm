package com.guidopintus.userrealm.service;

import com.guidopintus.userrealm.dto.AddRealmDTO;
import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmException;

public interface CreateRealm {

    RealmDTO create(AddRealmDTO addRealmDTO) throws RealmException;

}
