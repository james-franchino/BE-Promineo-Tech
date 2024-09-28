package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long staffId);
    Staff createStaff(Staff staff);
    Staff updateStaff(Long staffId, Staff staffDetails);
    void deleteStaff(Long staffId);
    List<Staff> getStaffByShelter(Long shelterId);
}
