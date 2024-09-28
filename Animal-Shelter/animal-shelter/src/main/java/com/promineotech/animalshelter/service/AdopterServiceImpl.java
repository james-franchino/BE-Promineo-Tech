package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.dao.AdopterRepository;
import com.promineotech.animalshelter.entity.Adopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopterServiceImpl implements AdopterService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Override
    public List<Adopter> getAllAdopters() {
        return adopterRepository.findAll();
    }

    @Override
    public Optional<Adopter> getAdopterById(Long adopterId) {
        return adopterRepository.findById(adopterId);
    }

    @Override
    public Adopter createAdopter(Adopter adopter) {
        return adopterRepository.save(adopter);
    }

    @Override
    public Adopter updateAdopter(Long adopterId, Adopter adopterDetails) {
        Optional<Adopter> adopter = adopterRepository.findById(adopterId);
        if (adopter.isPresent()) {
            Adopter existingAdopter = adopter.get();
            existingAdopter.setFirstName(adopterDetails.getFirstName());
            existingAdopter.setLastName(adopterDetails.getLastName());
            existingAdopter.setEmail(adopterDetails.getEmail());
            existingAdopter.setPhoneNumber(adopterDetails.getPhoneNumber());
            existingAdopter.setAddress(adopterDetails.getAddress());
            existingAdopter.setRegistrationDate(adopterDetails.getRegistrationDate());
            return adopterRepository.save(existingAdopter);
        }
        return null;
    }

    @Override
    public void deleteAdopter(Long adopterId) {
        adopterRepository.deleteById(adopterId);
    }


}
