package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AnimalDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AnimalDetailsDTO;
import com.promineotech.animalshelter.entity.Animal;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.mapper.AnimalMapper;
import com.promineotech.animalshelter.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalMapper animalMapper;

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> animalDTOs = animalService.getAllAnimals().stream()
                .map(animalMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(animalDTOs, HttpStatus.OK);
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<AnimalDetailsDTO> getAnimalById(@PathVariable Long animalId) {
        return animalService.getAnimalById(animalId)
                .map(animal -> new ResponseEntity<>(animalMapper.toDetailsDTO(animal), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Animal not found with id: " + animalId));
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@Valid @RequestBody AnimalDTO animalDTO) {
        Animal animal = animalMapper.toEntity(animalDTO);
        Animal savedAnimal = animalService.createAnimal(animal);
        return new ResponseEntity<>(animalMapper.toDTO(savedAnimal), HttpStatus.CREATED);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long animalId, @Valid @RequestBody AnimalDTO animalDTO) {
        Animal animal = animalMapper.toEntity(animalDTO);
        Animal updatedAnimal = animalService.updateAnimal(animalId, animal);
        if (updatedAnimal != null) {
            return new ResponseEntity<>(animalMapper.toDTO(updatedAnimal), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Animal not found with id: " + animalId);
        }
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByShelter(@PathVariable Long shelterId) {
        List<AnimalDTO> animalDTOs = animalService.getAnimalByShelter(shelterId).stream()
                .map(animalMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(animalDTOs, HttpStatus.OK);
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsBySpecies(@PathVariable String species) {
        List<AnimalDTO> animalDTOs = animalService.getAnimalBySpecies(species).stream()
                .map(animalMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(animalDTOs, HttpStatus.OK);
    }
}