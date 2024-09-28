package com.promineotech.animalshelter.dao;

import com.promineotech.animalshelter.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
