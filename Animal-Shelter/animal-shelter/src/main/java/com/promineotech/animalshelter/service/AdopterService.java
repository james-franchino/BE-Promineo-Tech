package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Adopter;

import java.util.List;
import java.util.Optional;

public interface AdopterService {
    List<Adopter> getAllAdopters();
    Optional<Adopter> getAdopterById(Long adopterId);
    Adopter createAdopter(Adopter adopter);
    Adopter updateAdopter(Long adopterId, Adopter adopterDetails);
    void deleteAdopter(Long adopterId);
}
