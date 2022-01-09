package com.junit.helloworld;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorld.class)
class HelloWorldTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void helloWorldTest() throws Exception{
        RequestBuilder request= MockMvcRequestBuilders
                .get("/helloWorld")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();

        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }
}