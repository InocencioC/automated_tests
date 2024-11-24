package com.example.star_wars_api.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.star_wars_api.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Answers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class)
public class PlanetServiceTest {
    //@Autowired
    @InjectMocks
    private PlanetService planetService;

   // @MockBean
    @Mock
    private PlanetRepository planetRepository;

    @Test
    public void createdPlanet_WithValidData_ReturnsPlanet() {
     when(planetRepository.save(PLANET)).thenReturn(PLANET);

     Planet sut = planetService.create(PLANET);

     assertThat(sut).isEqualTo(PLANET);

    }
}
