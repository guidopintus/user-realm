package com.guidopintus.userrealm.service;

import com.guidopintus.userrealm.dao.RealmDAO;
import com.guidopintus.userrealm.dto.AddRealmDTO;
import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.InvalidRealmNameException;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.model.RealmModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RealmService implements GetRealm, CreateRealm {

    @Autowired
    RealmDAO realmDAO;

    @Autowired
    @Qualifier("realmKeyGen")
    GenerateKey keyGen;

    @Override
    public RealmDTO get(Integer id) throws RealmException {


        RealmModel realm = realmDAO.get(id);
        if (realm == null) {
            throw new RealmNotFoundException();
        }
        RealmDTO dto = new RealmDTO(realm.getId(), realm.getName(), realm.getDescription(), realm.getKey());
        return dto;
    }

    @Override
    public RealmDTO create(AddRealmDTO addRealmDTO) throws RealmException {

        String key = keyGen.getKey();

        if(addRealmDTO.getName()==null || addRealmDTO.getName().isEmpty()){
            throw new InvalidRealmNameException();
        }

        RealmModel realm = new RealmModel(null, addRealmDTO.getName(), addRealmDTO.getDescription(), key);

        Integer id = realmDAO.add(realm);

        return new RealmDTO(id, addRealmDTO.getName(), addRealmDTO.getDescription(), key);

    }
}
