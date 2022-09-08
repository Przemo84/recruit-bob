package com.recruit.task.bob.api.controller;


import com.recruit.task.bob.BobApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CurrencyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void shouldReturn200AndDoubleValue() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/currency/search")
                .contentType("application/json")
                .param("rateDate", "2022-06-11"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void shouldReturn400DueToMisspelledInQueryString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/currency/search")
                .contentType("application/json")
                .param("rateDatesss", "2022-06-11"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}