package com.promineotech.animalshelter.mapper;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdopterDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdopterDetailsDTO;
import com.promineotech.animalshelter.entity.Adopter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AdopterMapper {

    private final AdoptionMapper adoptionMapper;

    public AdopterMapper(AdoptionMapper adoptionMapper) {
        this.adoptionMapper = adoptionMapper;
    }

    public AdopterDTO toDTO(Adopter adopter) {
        return new AdopterDTO(
                adopter.getAdopterId(),
                adopter.getFirstName(),
                adopter.getLastName(),
                adopter.getEmail(),
                adopter.getPhoneNumber(),
                adopter.getAddress(),
                adopter.getRegistrationDate()
        );
    }

    public AdopterDetailsDTO toDetailsDTO(Adopter adopter) {
        return new AdopterDetailsDTO(
                adopter.getAdopterId(),
                adopter.getFirstName(),
                adopter.getLastName(),
                adopter.getEmail(),
                adopter.getPhoneNumber(),
                adopter.getAddress(),
                adopter.getRegistrationDate(),
                adopter.getAdoptions().stream().map(adoptionMapper::toDTO).collect(Collectors.toList())
        );
    }

    public Adopter toEntity(AdopterDTO adopterDTO) {
        Adopter adopter = new Adopter();
        adopter.setAdopterId(adopterDTO.adopterId());
        adopter.setFirstName(adopterDTO.firstName());
        adopter.setLastName(adopterDTO.lastName());
        adopter.setEmail(adopterDTO.email());
        adopter.setPhoneNumber(adopterDTO.phoneNumber());
        adopter.setAddress(adopterDTO.address());
        adopter.setRegistrationDate(adopterDTO.registrationDate());
        return adopter;
    }
}