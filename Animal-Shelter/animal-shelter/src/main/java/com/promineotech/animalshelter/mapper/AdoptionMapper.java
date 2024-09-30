package com.promineotech.animalshelter.mapper;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AdoptionDTO;
import com.promineotech.animalshelter.entity.Adoption;
import org.springframework.stereotype.Component;

@Component
public class AdoptionMapper {

    public AdoptionDTO toDTO(Adoption adoption) {
        return new AdoptionDTO(
                adoption.getAdoptionId(),
                adoption.getAdopter().getAdopterId(),
                adoption.getAnimal().getAnimalId(),
                adoption.getAdoptionDate(),
                adoption.getStatus()
        );
    }

    public Adoption toEntity(AdoptionDTO adoptionDTO) {
        Adoption adoption = new Adoption();
        adoption.setAdoptionId(adoptionDTO.adoptionId());
        adoption.setAdoptionDate(adoptionDTO.adoptionDate());
        adoption.setStatus(adoptionDTO.status());
        return adoption;
    }
}