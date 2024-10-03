package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdoptionDTO;
import com.promineotech.animalshelter.entity.Adoption;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.mapper.AdoptionMapper;
import com.promineotech.animalshelter.service.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for managing Adoption resources.
 */
@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @Autowired
    private AdoptionMapper adoptionMapper;

    /**
     * Retrieves all adoptions.
     *
     * @return List of all adoptions
     */
    @GetMapping
    public ResponseEntity<List<AdoptionDTO>> getAllAdoptions() {
        List<AdoptionDTO> adoptionDTOs = adoptionService.getAllAdoptions().stream()
                .map(adoptionMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(adoptionDTOs, HttpStatus.OK);
    }

    /**
     * Retrieves a specific adoption by its ID.
     *
     * @param adoptionId The ID of the adoption to retrieve
     * @return The adoption details
     * @throws ResourceNotFoundException if the adoption is not found
     */
    @GetMapping("/{adoptionId}")
    public ResponseEntity<AdoptionDTO> getAdoptionById(@PathVariable Long adoptionId) {
        return adoptionService.getAdoptionById(adoptionId)
                .map(adoption -> new ResponseEntity<>(adoptionMapper.toDTO(adoption), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Adoption not found with id: " + adoptionId));
    }

    /**
     * Creates a new adoption.
     *
     * @param adoptionDTO The adoption data to create
     * @return The created adoption
     */
    @PostMapping
    public ResponseEntity<AdoptionDTO> createAdoption(@Valid @RequestBody AdoptionDTO adoptionDTO) {
        Adoption adoption = adoptionMapper.toEntity(adoptionDTO);
        Adoption savedAdoption = adoptionService.createAdoption(adoption);
        return new ResponseEntity<>(adoptionMapper.toDTO(savedAdoption), HttpStatus.CREATED);
    }

    @PutMapping("/{adoptionId}")
    public ResponseEntity<AdoptionDTO> updateAdoption(@PathVariable Long adoptionId, @Valid @RequestBody AdoptionDTO adoptionDTO) {
        Adoption adoption = adoptionMapper.toEntity(adoptionDTO);
        Adoption updatedAdoption = adoptionService.updateAdoption(adoptionId, adoption);
        if (updatedAdoption != null) {
            return new ResponseEntity<>(adoptionMapper.toDTO(updatedAdoption), HttpStatus.OK);
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
    public ResponseEntity<List<AdoptionDTO>> getAdoptionsByAdopter(@PathVariable Long adopterId) {
        List<AdoptionDTO> adoptionDTOs = adoptionService.getAdoptionsByAdopter(adopterId).stream()
                .map(adoptionMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(adoptionDTOs, HttpStatus.OK);
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<AdoptionDTO>> getAdoptionsByAnimal(@PathVariable Long animalId) {
        List<AdoptionDTO> adoptionDTOs = adoptionService.getAdoptionsByAnimal(animalId).stream()
                .map(adoptionMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(adoptionDTOs, HttpStatus.OK);
    }
}