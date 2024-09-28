package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.dao.AdoptionRepository;
import com.promineotech.animalshelter.entity.Adoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    @Override
    public List<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }

    @Override
    public Optional<Adoption> getAdoptionById(Long adoptionId) {
        return adoptionRepository.findById(adoptionId);
    }

    @Override
    public Adoption createAdoption(Adoption adoption) {
        return adoptionRepository.save(adoption);
    }

    @Override
    public Adoption updateAdoption(Long adoptionId, Adoption adoptionDetails) {
        Optional<Adoption> adoption = adoptionRepository.findById(adoptionId);
        if (adoption.isPresent()) {
            Adoption existingAdoption = adoption.get();
            existingAdoption.setAdopter(adoptionDetails.getAdopter());
            existingAdoption.setAnimal(adoptionDetails.getAnimal());
            existingAdoption.setAdoptionDate(adoptionDetails.getAdoptionDate());
            existingAdoption.setStatus(adoptionDetails.getStatus());
            return adoptionRepository.save(existingAdoption);
        }
        return null;
    }

    @Override
    public void deleteAdoption(Long adoptionId) {
        adoptionRepository.deleteById(adoptionId);
    }

    @Override
    public List<Adoption> getAdoptionsByAdopter(Long adopterId) {
        return adoptionRepository.findByAdopter_AdopterId(adopterId);
    }

    @Override
    public List<Adoption> getAdoptionsByAnimal(Long animalId) {
        return adoptionRepository.findByAnimal_AnimalId(animalId);
    }
}