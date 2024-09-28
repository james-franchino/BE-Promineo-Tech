package com.promineotech.animalshelter.dao;

import com.promineotech.animalshelter.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    List<Adoption> findByAdopter_AdopterId(Long adopterId);
    List<Adoption> findByAnimal_AnimalId(Long animalId);
}
