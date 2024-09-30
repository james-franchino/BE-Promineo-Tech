package com.promineotech.animalshelter.dto;

import com.promineotech.animalshelter.entity.Adoption;
import com.promineotech.animalshelter.entity.Animal;

import java.time.LocalDate;
import java.util.List;

public class AnimalShelterDTOs {

    public record ShelterDTO(
            Long shelterId,
            String shelterName,
            String address,
            String phoneNumber,
            String email,
            Integer capacity
    ) {}

    public record AnimalDTO(
            Long animalId,
            String name,
            String species,
            String breed,
            Integer age,
            String gender,
            Animal.AnimalStatus status,
            LocalDate intakeDate,
            Long shelterId
    ) {}

    public record AdopterDTO(
            Long adopterId,
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String address,
            LocalDate registrationDate
    ) {}

    public record StaffDTO(
            Long staffId,
            String firstName,
            String lastName,
            String role,
            String email,
            String phoneNumber,
            LocalDate hireDate,
            Long shelterId
    ) {}

    public record AdoptionDTO(
            Long adoptionId,
            Long adopterId,
            Long animalId,
            LocalDate adoptionDate,
            Adoption.AdoptionStatus status
    ) {}

    public record ShelterDetailsDTO(
            Long shelterId,
            String shelterName,
            String address,
            String phoneNumber,
            String email,
            Integer capacity,
            List<AnimalDTO> animals,
            List<StaffDTO> staff
    ) {}

    public record AnimalDetailsDTO(
            Long animalId,
            String name,
            String species,
            String breed,
            Integer age,
            String gender,
            Animal.AnimalStatus status,
            LocalDate intakeDate,
            ShelterDTO shelter,
            List<AdoptionDTO> adoptions
    ) {}

    public record AdopterDetailsDTO(
            Long adopterId,
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String address,
            LocalDate registrationDate,
            List<AdoptionDTO> adoptions
    ) {}
}

