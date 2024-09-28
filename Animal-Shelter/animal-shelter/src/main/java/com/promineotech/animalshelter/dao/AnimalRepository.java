package com.promineotech.animalshelter.dao;

import com.promineotech.animalshelter.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByShelter_ShelterId(Long shelterId);
    List<Animal> findBySpecies(String species);
}
