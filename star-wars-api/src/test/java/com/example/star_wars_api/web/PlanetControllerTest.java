package com.example.star_wars_api.web;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static com.example.star_wars_api.common.PlanetConstants.PLANET;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.star_wars_api.domain.PlanetService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PlanetController.class)
public class PlanetControllerTest {
  
        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private PlanetService planetService;

        @Test
        public void createPlanet_WithValidData_ReturnsCreated() throws Exception {
            when(planetService.create(PLANET)).thenReturn(PLANET);
            
            mockMvc.perform(post("/planets").content(objectMapper.writeValueAsString(PLANET)).contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(PLANET));
        } 
}