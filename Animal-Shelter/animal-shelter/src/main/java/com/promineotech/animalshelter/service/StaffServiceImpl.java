package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.dao.StaffRepository;
import com.promineotech.animalshelter.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Long staffId, Staff staffDetails) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if (staff.isPresent()) {
            Staff existingStaff = staff.get();
            existingStaff.setFirstName(staffDetails.getFirstName());
            existingStaff.setLastName(staffDetails.getLastName());
            existingStaff.setRole(staffDetails.getRole());
            existingStaff.setEmail(staffDetails.getEmail());
            existingStaff.setPhoneNumber(staffDetails.getPhoneNumber());
            existingStaff.setHireDate(staffDetails.getHireDate());
            existingStaff.setShelter(staffDetails.getShelter());
            return staffRepository.save(existingStaff);
        }
        return null;
    }

    @Override
    public void deleteStaff(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getStaffByShelter(Long shelterId) {
        return staffRepository.findByShelter_ShelterId(shelterId);
    }
}
