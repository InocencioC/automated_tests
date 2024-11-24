package com.example.star_wars_api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.star_wars_api.domain.Planet;
import com.example.star_wars_api.domain.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

@Autowired
private PlanetService planetServie;

@PostMapping
public ResponseEntity<Planet> create(@RequestBody Planet planet){
    Planet planetCreated = planetServie.create(planet);
    return ResponseEntity.status(HttpStatus.CREATED).body(planetCreated);
}

}
