package com.example.star_wars_api.domain;

import static com.example.star_wars_api.common.PlanetConstants.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createdPlanet_WithValidData_ReturnsPlanet() {
      Planet planet = planetRepository.save(PLANET);

      Planet sut = testEntityManager.find(Planet.class, planet.getId());

      System.out.println(planet);

      assertThat(sut).isNotNull();
      assertThat(sut.getName()).isEqualTo(PLANET.getName());
      assertThat(sut.getClimate()).isEqualTo(PLANET.getClimate());
      assertThat(sut.getTerrain()).isEqualTo(PLANET.getTerrain());

    }


    @Test
    public void createdPlanet_WithInvalidData_ThrowsException() {
        Planet emptyPlanet = new Planet();
        Planet invalidPlanet = new Planet("", "", "");

        assertThatThrownBy(() -> planetRepository.save(emptyPlanet)).isInstanceOf(getClass());
        assertThatThrownBy(() -> planetRepository.save(invalidPlanet));
    }
 }


