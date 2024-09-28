package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.entity.Adopter;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.service.AdopterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopters")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @GetMapping
    public ResponseEntity<List<Adopter>> getAllAdopters() {
        return new ResponseEntity<>(adopterService.getAllAdopters(), HttpStatus.OK);
    }

    @GetMapping("/{adopterId}")
    public ResponseEntity<Adopter> getAdopterById(@PathVariable Long adopterId) {
        return adopterService.getAdopterById(adopterId)
                .map(adopter -> new ResponseEntity<>(adopter, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Adopter not found with id: " + adopterId));
    }

    @PostMapping
    public ResponseEntity<Adopter> createAdopter(@Valid @RequestBody Adopter adopter) {
        return new ResponseEntity<>(adopterService.createAdopter(adopter), HttpStatus.CREATED);
    }

    @PutMapping("/{adopterId}")
    public ResponseEntity<Adopter> updateAdopter(@PathVariable Long adopterId, @Valid @RequestBody Adopter adopter) {
        Adopter updatedAdopter = adopterService.updateAdopter(adopterId, adopter);
        if (updatedAdopter != null) {
            return new ResponseEntity<>(updatedAdopter, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Adopter not found with id: " + adopterId);
        }
    }

    @DeleteMapping("/{adopterId}")
    public ResponseEntity<Void> deleteAdopter(@PathVariable Long adopterId) {
        adopterService.deleteAdopter(adopterId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}