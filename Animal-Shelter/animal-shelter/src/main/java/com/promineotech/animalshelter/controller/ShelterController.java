package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.ShelterDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.ShelterDetailsDTO;
import com.promineotech.animalshelter.entity.Shelter;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.mapper.ShelterMapper;
import com.promineotech.animalshelter.service.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private ShelterMapper shelterMapper;

    @GetMapping
    public ResponseEntity<List<ShelterDTO>> getAllShelters() {
        List<ShelterDTO> shelterDTOs = shelterService.getAllShelters().stream()
                .map(shelterMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(shelterDTOs, HttpStatus.OK);
    }

    @GetMapping("/{shelterId}")
    public ResponseEntity<ShelterDetailsDTO> getShelterById(@PathVariable Long shelterId) {
        return shelterService.getShelterById(shelterId)
                .map(shelter -> new ResponseEntity<>(shelterMapper.toDetailsDTO(shelter), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found with id: " + shelterId));
    }

    @PostMapping
    public ResponseEntity<ShelterDTO> createShelter(@Valid @RequestBody ShelterDTO shelterDTO) {
        Shelter shelter = shelterMapper.toEntity(shelterDTO);
        Shelter savedShelter = shelterService.createShelter(shelter);
        return new ResponseEntity<>(shelterMapper.toDTO(savedShelter), HttpStatus.CREATED);
    }

    @PutMapping("/{shelterId}")
    public ResponseEntity<ShelterDTO> updateShelter(@PathVariable Long shelterId, @Valid @RequestBody ShelterDTO shelterDTO) {
        Shelter shelter = shelterMapper.toEntity(shelterDTO);
        Shelter updatedShelter = shelterService.updateShelter(shelterId, shelter);
        if (updatedShelter != null) {
            return new ResponseEntity<>(shelterMapper.toDTO(updatedShelter), HttpStatus.OK);
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