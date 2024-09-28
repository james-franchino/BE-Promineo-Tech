package com.promineotech.animalshelter.dao;

import com.promineotech.animalshelter.entity.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Long> {
}
