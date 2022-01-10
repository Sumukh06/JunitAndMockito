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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemBisMock {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    SomeBusinessImpl someBusiness;

    @Test
    public void itemBisMockTest() throws Exception {
        when(someBusiness.returndummyItem()).thenReturn(new ItemModel(200,"fan",100,1));
        RequestBuilder request= MockMvcRequestBuilders
                .get("/dummyItem-business")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{id:200,name:fan,price:100,quantity:1}"))
                .andReturn();
    }
}
