package com.guidopintus.userrealm.controller;


import com.guidopintus.userrealm.dto.RealmDTO;
import com.guidopintus.userrealm.exception.RealmNotFoundException;
import com.guidopintus.userrealm.service.CreateRealm;
import com.guidopintus.userrealm.service.GetRealm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void givenUserNotExists_whenUserRetrieved_then400IsReceived() throws Exception, RealmNotFoundException {

        Integer mockId=0;
        given(getRealmService.get(mockId)).willThrow(RealmNotFoundException.class);

        mvc.perform(get("/service/user/realm/"+mockId.toString()))
                .andExpect(status().isNotFound());
    }

}
