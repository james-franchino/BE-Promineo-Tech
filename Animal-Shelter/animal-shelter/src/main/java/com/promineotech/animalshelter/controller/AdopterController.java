package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdopterDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdopterDetailsDTO;
import com.promineotech.animalshelter.entity.Adopter;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.mapper.AdopterMapper;
import com.promineotech.animalshelter.service.AdopterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for managing Adopter resources.
 */
@RestController
@RequestMapping("/adopters")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @Autowired
    private AdopterMapper adopterMapper;

    /**
     * Retrieves all adopters.
     *
     * @return List of all adopters
     */
    @GetMapping
    public ResponseEntity<List<AdopterDTO>> getAllAdopters() {
        List<AdopterDTO> adopterDTOs = adopterService.getAllAdopters().stream()
                .map(adopterMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(adopterDTOs, HttpStatus.OK);
    }

    /**
     * Retrieves a specific adopter by their ID.
     *
     * @param adopterId The ID of the adopter to retrieve
     * @return The adopter details
     * @throws ResourceNotFoundException if the adopter is not found
     */
    @GetMapping("/{adopterId}")
    public ResponseEntity<AdopterDetailsDTO> getAdopterById(@PathVariable Long adopterId) {
        return adopterService.getAdopterById(adopterId)
                .map(adopter -> new ResponseEntity<>(adopterMapper.toDetailsDTO(adopter), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Adopter not found with id: " + adopterId));
    }

    /**
     * Creates a new adopter.
     *
     * @param adopterDTO The adopter data to create
     * @return The created adopter
     */
    @PostMapping
    public ResponseEntity<AdopterDTO> createAdopter(@Valid @RequestBody AdopterDTO adopterDTO) {
        Adopter adopter = adopterMapper.toEntity(adopterDTO);
        Adopter savedAdopter = adopterService.createAdopter(adopter);
        return new ResponseEntity<>(adopterMapper.toDTO(savedAdopter), HttpStatus.CREATED);
    }

    @PutMapping("/{adopterId}")
    public ResponseEntity<AdopterDTO> updateAdopter(@PathVariable Long adopterId, @Valid @RequestBody AdopterDTO adopterDTO) {
        Adopter adopter = adopterMapper.toEntity(adopterDTO);
        Adopter updatedAdopter = adopterService.updateAdopter(adopterId, adopter);
        if (updatedAdopter != null) {
            return new ResponseEntity<>(adopterMapper.toDTO(updatedAdopter), HttpStatus.OK);
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