package com.promineotech.animalshelter.mapper;

import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AnimalDTO;
import com.promineotech.animalshelter.dto.AnimalShelterDTOs.AnimalDetailsDTO;
import com.promineotech.animalshelter.entity.Animal;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AnimalMapper {

    private final ShelterMapper shelterMapper;
    private final AdoptionMapper adoptionMapper;

    public AnimalMapper(@Lazy ShelterMapper shelterMapper, AdoptionMapper adoptionMapper) {
        this.shelterMapper = shelterMapper;
        this.adoptionMapper = adoptionMapper;
    }

    public AnimalDTO toDTO(Animal animal) {
        return new AnimalDTO(
                animal.getAnimalId(),
                animal.getName(),
                animal.getSpecies(),
                animal.getBreed(),
                animal.getAge(),
                animal.getGender(),
                animal.getStatus(),
                animal.getIntakeDate(),
                animal.getShelter() != null ? animal.getShelter().getShelterId() : null
        );
    }

    public AnimalDetailsDTO toDetailsDTO(Animal animal) {
        return new AnimalDetailsDTO(
                animal.getAnimalId(),
                animal.getName(),
                animal.getSpecies(),
                animal.getBreed(),
                animal.getAge(),
                animal.getGender(),
                animal.getStatus(),
                animal.getIntakeDate(),
                animal.getShelter() != null ? shelterMapper.toDTO(animal.getShelter()) : null,
                animal.getAdoptions()
                        != null ? animal.getAdoptions().stream().map(adoptionMapper::toDTO).collect(Collectors.toList())
                        : null
        );
    }

    public Animal toEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setAnimalId(animalDTO.animalId());
        animal.setName(animalDTO.name());
        animal.setSpecies(animalDTO.species());
        animal.setBreed(animalDTO.breed());
        animal.setAge(animalDTO.age());
        animal.setGender(animalDTO.gender());
        animal.setStatus(animalDTO.status());
        animal.setIntakeDate(animalDTO.intakeDate());
        return animal;
    }
}