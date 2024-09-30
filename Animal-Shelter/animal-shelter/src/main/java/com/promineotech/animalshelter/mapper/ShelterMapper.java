package com.promineotech.animalshelter.mapper;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.ShelterDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.ShelterDetailsDTO;
import com.promineotech.animalshelter.entity.Shelter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ShelterMapper {

    private final AnimalMapper animalMapper;
    private final StaffMapper staffMapper;

    public ShelterMapper(@Lazy AnimalMapper animalMapper, StaffMapper staffMapper) {
        this.animalMapper = animalMapper;
        this.staffMapper = staffMapper;
    }

    public ShelterDTO toDTO(Shelter shelter) {
        return new ShelterDTO(
                shelter.getShelterId(),
                shelter.getShelterName(),
                shelter.getAddress(),
                shelter.getPhoneNumber(),
                shelter.getEmail(),
                shelter.getCapacity()
        );
    }

    public ShelterDetailsDTO toDetailsDTO(Shelter shelter) {
        return new ShelterDetailsDTO(
                shelter.getShelterId(),
                shelter.getShelterName(),
                shelter.getAddress(),
                shelter.getPhoneNumber(),
                shelter.getEmail(),
                shelter.getCapacity(),
                shelter.getAnimals()
                        != null ? shelter.getAnimals().stream().map(animalMapper::toDTO).collect(Collectors.toList())
                        : null,
                shelter.getStaff()
                        != null ? shelter.getStaff().stream().map(staffMapper::toDTO).collect(Collectors.toList())
                        : null
        );
    }

    public Shelter toEntity(ShelterDTO shelterDTO) {
        Shelter shelter = new Shelter();
        shelter.setShelterId(shelterDTO.shelterId());
        shelter.setShelterName(shelterDTO.shelterName());
        shelter.setAddress(shelterDTO.address());
        shelter.setPhoneNumber(shelterDTO.phoneNumber());
        shelter.setEmail(shelterDTO.email());
        shelter.setCapacity(shelterDTO.capacity());
        return shelter;
    }
}

