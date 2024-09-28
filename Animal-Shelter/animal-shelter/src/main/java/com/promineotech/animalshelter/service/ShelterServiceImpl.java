package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.dao.ShelterRepository;
import com.promineotech.animalshelter.entity.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterServiceImpl implements ShelterService {
    @Autowired
    private ShelterRepository shelterRepository;

    @Override
    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    @Override
    public Optional<Shelter> getShelterById(Long shelterId) {
        return shelterRepository.findById(shelterId);
    }

    @Override
    public Shelter createShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    @Override
    public Shelter updateShelter(Long shelterId, Shelter shelterDetails) {
        Optional<Shelter> shelter = shelterRepository.findById(shelterId);
        if (shelter.isPresent()) {
            Shelter existingShelter = shelter.get();
            existingShelter.setShelterName(shelterDetails.getShelterName());
            existingShelter.setAddress(shelterDetails.getAddress());
            existingShelter.setPhoneNumber(shelterDetails.getPhoneNumber());
            existingShelter.setEmail(shelterDetails.getEmail());
            existingShelter.setCapacity(shelterDetails.getCapacity());
            return shelterRepository.save(existingShelter);
        }
        return null;
    }

    @Override
    public void deleteShelter(Long shelterId) {
        shelterRepository.deleteById(shelterId);
    }
}
