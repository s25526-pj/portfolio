package com.kalinowski.exchange.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalinowski.exchange.model.Currencies;
import com.kalinowski.exchange.model.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "ADMIN", password = "Dupa", username = "ADMIN")
    void testGetCurr_shouldReturnAllCurrencies() throws Exception {
        mockMvc.perform(get("/api/v1/exchange"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    @WithMockUser(roles = "ADMIN", password = "Dupa", username = "ADMIN")
    void testConvert_shouldReturnExchnageApiResponse() throws Exception {
        Query query = Query.builder()
                .from("PLN")
                .to("USD")
                .amount(50000)
                .build();
        mockMvc.perform(post("/api/v1/exchange").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(query)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.success", equalTo(true)));
    }



}