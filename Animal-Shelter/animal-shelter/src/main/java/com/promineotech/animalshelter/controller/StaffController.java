package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.StaffDTO;
import com.promineotech.animalshelter.entity.Staff;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.mapper.StaffMapper;
import com.promineotech.animalshelter.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffMapper staffMapper;

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        List<StaffDTO> staffDTOs = staffService.getAllStaff().stream()
                .map(staffMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(staffDTOs, HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable Long staffId) {
        return staffService.getStaffById(staffId)
                .map(staff -> new ResponseEntity<>(staffMapper.toDTO(staff), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + staffId));
    }

    @PostMapping
    public ResponseEntity<StaffDTO> createStaff(@Valid @RequestBody StaffDTO staffDTO) {
        Staff staff = staffMapper.toEntity(staffDTO);
        Staff savedStaff = staffService.createStaff(staff);
        return new ResponseEntity<>(staffMapper.toDTO(savedStaff), HttpStatus.CREATED);
    }

    @PutMapping("/{staffId}")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable Long staffId, @Valid @RequestBody StaffDTO staffDTO) {
        Staff staff = staffMapper.toEntity(staffDTO);
        Staff updatedStaff = staffService.updateStaff(staffId, staff);
        if (updatedStaff != null) {
            return new ResponseEntity<>(staffMapper.toDTO(updatedStaff), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Staff not found with id: " + staffId);
        }
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long staffId) {
        staffService.deleteStaff(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<List<StaffDTO>> getStaffByShelter(@PathVariable Long shelterId) {
        List<StaffDTO> staffDTOs = staffService.getStaffByShelter(shelterId).stream()
                .map(staffMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(staffDTOs, HttpStatus.OK);
    }
}