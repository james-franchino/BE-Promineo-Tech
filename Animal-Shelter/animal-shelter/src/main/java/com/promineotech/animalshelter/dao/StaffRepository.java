package com.promineotech.animalshelter.dao;

import com.promineotech.animalshelter.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByShelter_ShelterId(Long shelterId);
}
