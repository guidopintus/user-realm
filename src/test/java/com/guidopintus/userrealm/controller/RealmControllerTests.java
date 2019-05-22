package com.guidopintus.userrealm.controller;


import com.guidopintus.userrealm.dto.AddRealmDTO;
import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.DuplicateRealmNameException;
import com.guidopintus.userrealm.exception.InvalidRealmNameException;
import com.guidopintus.userrealm.exception.RealmException;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.service.CreateRealm;
import com.guidopintus.userrealm.service.GetRealm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(RealmController.class)
public class RealmControllerTests {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private GetRealm getRealmService;

    @MockBean
    private CreateRealm createRealmService;

    @Test
    public void givenUserNotExists_whenRealmRetrieved_then404IsReceived() throws Exception, RealmException {

        Integer mockId = 0;
        given(getRealmService.get(mockId)).willThrow(RealmNotFoundException.class);

        mvc.perform(get("/service/user/realm/" + mockId.toString()))
                .andExpect(status().isNotFound());

    }


    @Test
    public void givenUserExists_whenUserRetrieved_thenUserReceivedJson() throws Exception, RealmException {

        Integer mockId = 1234;
        RealmDTO dto = new RealmDTO(1234, "realmName", "realmDescription", "realmKey");
        given(getRealmService.get(mockId)).willReturn(dto);
        mvc.perform(get("/service/user/realm/" + mockId.toString()).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(dto.getId()))
                .andExpect(jsonPath("$.name").value(dto.getName()))
                .andExpect(jsonPath("$.description").value(dto.getDescription()))
                .andExpect(jsonPath("$.key").value(dto.getKey()));
    }


    @Test
    public void givenUserExists_whenUserRetrieved_thenUserReceivedXml() throws Exception, RealmException {

        Integer mockId = 1234;
        RealmDTO dto = new RealmDTO(1234, "realmName", "realmDescription", "realmKey");
        given(getRealmService.get(mockId)).willReturn(dto);
        mvc.perform(get("/service/user/realm/" + mockId.toString()).accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isOk())
                .andExpect(xpath("//@id").string(dto.getId().toString()))
                .andExpect(xpath("//@name").string(dto.getName()))
                .andExpect(xpath("//description").string(dto.getDescription()))
                .andExpect(xpath("//key").string(dto.getKey()));
    }

    @Test
    public void givenDuplicateRealm_whenRealmCreated_then400IsReceived() throws Exception, RealmException {

        AddRealmDTO dto = new AddRealmDTO("realmName", "realmDescription");
        given(createRealmService.create(dto)).willThrow(DuplicateRealmNameException.class);

        mvc.perform(post("/service/user/realm/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenInvalidRealmName_whenRealmCreated_then400IsReceived() throws Exception, RealmException {

        AddRealmDTO dto = new AddRealmDTO("realmName", "realmDescription");
        given(createRealmService.create(dto)).willThrow(InvalidRealmNameException.class);

        mvc.perform(post("/service/user/realm/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isBadRequest());
    }


}
