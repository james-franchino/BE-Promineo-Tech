package com.promineotech.animalshelter.controller;

import com.promineotech.animalshelter.entity.Staff;
import com.promineotech.animalshelter.exception.ResourceNotFoundException;
import com.promineotech.animalshelter.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        return new ResponseEntity<>(staffService.getAllStaff(), HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long staffId) {
        return staffService.getStaffById(staffId)
                .map(staff -> new ResponseEntity<>(staff, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + staffId));
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@Valid @RequestBody Staff staff) {
        return new ResponseEntity<>(staffService.createStaff(staff), HttpStatus.CREATED);
    }

    @PutMapping("/{staffId}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long staffId, @Valid @RequestBody Staff staff) {
        Staff updatedStaff = staffService.updateStaff(staffId, staff);
        if (updatedStaff != null) {
            return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
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
    public ResponseEntity<List<Staff>> getStaffByShelter(@PathVariable Long shelterId) {
        return new ResponseEntity<>(staffService.getStaffByShelter(shelterId), HttpStatus.OK);
    }
}