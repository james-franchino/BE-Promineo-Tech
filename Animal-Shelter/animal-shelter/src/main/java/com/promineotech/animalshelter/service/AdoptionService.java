package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Adoption;

import java.util.List;
import java.util.Optional;

public interface AdoptionService {
    List<Adoption> getAllAdoptions();
    Optional<Adoption> getAdoptionById(Long adoptionId);
    Adoption createAdoption(Adoption adoption);
    Adoption updateAdoption(Long adoptionId, Adoption adoptionDetails);
    void deleteAdoption(Long adoptionId);
    List<Adoption> getAdoptionsByAdopter(Long adopterId);
    List<Adoption> getAdoptionsByAnimal(Long animalId);
}
