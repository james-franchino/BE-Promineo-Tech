package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.entity.Animal;
import com.promineotech.animalshelter.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return new ResponseEntity<>(animalService.getAllAnimals(), HttpStatus.OK);
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long animalId) {
        return animalService.getAnimalById(animalId)
                .map(animal -> new ResponseEntity<>(animal, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@Valid @RequestBody Animal animal) {
        return new ResponseEntity<>(animalService.createAnimal(animal), HttpStatus.CREATED);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long animalId, @Valid @RequestBody Animal animal) {
        Animal updatedAnimal = animalService.updateAnimal(animalId, animal);
        if (updatedAnimal != null) {
            return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<List<Animal>> getAnimalsByShelter(@PathVariable Long shelterId) {
        return new ResponseEntity<>(animalService.getAnimalByShelter(shelterId), HttpStatus.OK);
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<Animal>> getAnimalsBySpecies(@PathVariable String species) {
        return new ResponseEntity<>(animalService.getAnimalBySpecies(species), HttpStatus.OK);
    }
}