package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.entity.Shelter;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.service.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping
    public ResponseEntity<List<Shelter>> getAllShelters() {
        return new ResponseEntity<>(shelterService.getAllShelters(), HttpStatus.OK);
    }

    @GetMapping("/{shelterId}")
    public ResponseEntity<Shelter> getShelterById(@PathVariable Long shelterId) {
        return shelterService.getShelterById(shelterId)
                .map(shelter -> new ResponseEntity<>(shelter, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found with id: " + shelterId));
    }

    @PostMapping
    public ResponseEntity<Shelter> createShelter(@Valid @RequestBody Shelter shelter) {
        return new ResponseEntity<>(shelterService.createShelter(shelter), HttpStatus.CREATED);
    }

    @PutMapping("/{shelterId}")
    public ResponseEntity<Shelter> updateShelter(@PathVariable Long shelterId, @Valid @RequestBody Shelter shelter) {
        Shelter updatedShelter = shelterService.updateShelter(shelterId, shelter);
        if (updatedShelter != null) {
            return new ResponseEntity<>(updatedShelter, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Shelter not found with id: " + shelterId);
        }
    }

    @DeleteMapping("/{shelterId}")
    public ResponseEntity<Void> deleteShelter(@PathVariable Long shelterId) {
        shelterService.deleteShelter(shelterId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}