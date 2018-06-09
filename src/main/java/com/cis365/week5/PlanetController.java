package com.cis365.week5;


import com.cis365.week5.models.Planet;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class PlanetController {

    @RequestMapping("/planet")
    public List<Planet> planet()
    {
        return DataStore.listPlanets();
    }
    
     @GetMapping("/planet/{planetId}")
    public Planet getPlanetById(@PathVariable(value = "planetId") String planetId) {
        return DataStore.findPlanetById(planetId);
    }

    @PutMapping(value="/planet/{planetId}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Planet updatePlanet(@PathVariable(value = "planetId") String planetId, @RequestBody Planet planetToUpdate) {
        return DataStore.updatePlanet(planetId, planetToUpdate);
    }

    @PostMapping(value="/planet", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Planet addPlanet(@RequestBody Planet planetToUpdate) {
        return DataStore.addPlanet(planetToUpdate);
    }

    @DeleteMapping(value = "/planet/{planetId}")
    public Planet deletePlanet(@PathVariable(value = "planetId") String planetId) {
        return DataStore.deletePlanet(planetId);
    }

}
