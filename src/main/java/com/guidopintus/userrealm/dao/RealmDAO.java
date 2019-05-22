package com.guidopintus.userrealm.dao;

import com.guidopintus.userrealm.exception.DuplicateRealmNameException;
import com.guidopintus.userrealm.exception.InvalidRealmNameException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.model.RealmModel;
import org.springframework.stereotype.Repository;

@Repository
public interface RealmDAO {

    Integer add(RealmModel realm) throws DuplicateRealmNameException, InvalidRealmNameException;

    RealmModel get(Integer id) throws RealmNotFoundException;

}
