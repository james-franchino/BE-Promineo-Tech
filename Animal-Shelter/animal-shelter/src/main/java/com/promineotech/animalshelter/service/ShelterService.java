package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Shelter;

import java.util.List;
import java.util.Optional;

public interface ShelterService {
    List<Shelter> getAllShelters();
    Optional<Shelter> getShelterById(Long shelterId);
    Shelter createShelter(Shelter shelter);
    Shelter updateShelter(Long shelterId, Shelter shelterDetails);
    void deleteShelter(Long shelterId);
}
