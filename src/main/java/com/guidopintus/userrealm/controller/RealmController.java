package com.guidopintus.userrealm.controller;

import com.guidopintus.userrealm.dto.AddRealmDTO;
import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.service.CreateRealm;
import com.guidopintus.userrealm.service.GetRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("service/user/realm")
public class RealmController {


    @Autowired
    private GetRealm getRealm;

    @Autowired
    private CreateRealm createRealm;

    @GetMapping(value = "/{id}"
            ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public @ResponseBody RealmDTO getUser(@PathVariable Integer id) throws RealmException {
        return getRealm.get(id);
    }

    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
            ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody RealmDTO addUser(@RequestBody AddRealmDTO addRealmDTO) throws RealmException{
        return null;
    }



}
