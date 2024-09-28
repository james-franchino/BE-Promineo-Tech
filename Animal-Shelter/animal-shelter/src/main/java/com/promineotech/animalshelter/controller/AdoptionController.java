package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.entity.Adoption;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.service.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @GetMapping
    public ResponseEntity<List<Adoption>> getAllAdoptions() {
        return new ResponseEntity<>(adoptionService.getAllAdoptions(), HttpStatus.OK);
    }

    @GetMapping("/{adoptionId}")
    public ResponseEntity<Adoption> getAdoptionById(@PathVariable Long adoptionId) {
        return adoptionService.getAdoptionById(adoptionId)
                .map(adoption -> new ResponseEntity<>(adoption, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Adoption not found with id: " + adoptionId));
    }

    @PostMapping
    public ResponseEntity<Adoption> createAdoption(@Valid @RequestBody Adoption adoption) {
        return new ResponseEntity<>(adoptionService.createAdoption(adoption), HttpStatus.CREATED);
    }

    @PutMapping("/{adoptionId}")
    public ResponseEntity<Adoption> updateAdoption(@PathVariable Long adoptionId, @Valid @RequestBody Adoption adoption) {
        Adoption updatedAdoption = adoptionService.updateAdoption(adoptionId, adoption);
        if (updatedAdoption != null) {
            return new ResponseEntity<>(updatedAdoption, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Adoption not found with id: " + adoptionId);
        }
    }

    @DeleteMapping("/{adoptionId}")
    public ResponseEntity<Void> deleteAdoption(@PathVariable Long adoptionId) {
        adoptionService.deleteAdoption(adoptionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/adopter/{adopterId}")
    public ResponseEntity<List<Adoption>> getAdoptionsByAdopter(@PathVariable Long adopterId) {
        return new ResponseEntity<>(adoptionService.getAdoptionsByAdopter(adopterId), HttpStatus.OK);
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Adoption>> getAdoptionsByAnimal(@PathVariable Long animalId) {
        return new ResponseEntity<>(adoptionService.getAdoptionsByAnimal(animalId), HttpStatus.OK);
    }
}