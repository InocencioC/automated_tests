package com.example.swplanetapi.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
  private PlanetRepository planetRepository;

  public PlanetService(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public Planet create(Planet planet) {
    return planetRepository.save(planet);
  }

  public Optional<Planet> get(Long id) {
    return planetRepository.findById(id);
  }

  public Optional<Planet> getByName(String name) {
    return planetRepository.findByName(name);
  }
  public List<Planet> list(String terrain, String climate) {
    Example<Planet> query = QueryBuilder
    .makeQuery(new Planet(climate, terrain));
    return planetRepository.findAll(query);
  }

  public Optional<Planet> searchById(Long id) {
    return planetRepository.findById(id);
  }
  
  public void remove(Long id) {
   var planetOptional = searchById(id);
   if (planetOptional.isPresent()) {
   planetRepository.delete(planetOptional.get());
   } else {
    throw new EmptyResultDataAccessException("Entity not found", 1);
   }
  }
}
