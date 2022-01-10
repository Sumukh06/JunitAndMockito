package com.junit.item;

import com.junit.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemDataLayerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SomeBusinessImpl someBusiness;

    @Test
    public void BisToData() throws Exception {
        when(someBusiness.findAllData()).thenReturn(Arrays.asList(
                new ItemModel(1,"Fan",100,2,200),
                new ItemModel(2,"Book",50,3,150)));

        RequestBuilder request= MockMvcRequestBuilders
                .get("/itemList")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("[{id:1,name:Fan,price:100,quantity:2,value:200}"+
                        ",{id:2,name:Book,price:50,quantity:3,value:150}]"))
                .andReturn();
    }

}
