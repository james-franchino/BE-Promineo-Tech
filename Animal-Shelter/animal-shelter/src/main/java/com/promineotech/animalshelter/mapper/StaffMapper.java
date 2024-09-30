package com.promineotech.animalshelter.mapper;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.StaffDTO;
import com.promineotech.animalshelter.entity.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public StaffDTO toDTO(Staff staff) {
        return new StaffDTO(
                staff.getStaffId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getRole(),
                staff.getEmail(),
                staff.getPhoneNumber(),
                staff.getHireDate(),
                staff.getShelter().getShelterId()
        );
    }

    public Staff toEntity(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setStaffId(staffDTO.staffId());
        staff.setFirstName(staffDTO.firstName());
        staff.setLastName(staffDTO.lastName());
        staff.setRole(staffDTO.role());
        staff.setEmail(staffDTO.email());
        staff.setPhoneNumber(staffDTO.phoneNumber());
        staff.setHireDate(staffDTO.hireDate());
        return staff;
    }
}