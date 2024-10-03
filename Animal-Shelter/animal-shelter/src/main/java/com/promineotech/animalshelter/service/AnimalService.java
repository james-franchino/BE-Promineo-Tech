package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Animal;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Animal entities.
 */
public interface AnimalService {

    /**
     * Retrieves all animals.
     *
     * @return List of all animals
     */
    List<Animal> getAllAnimals();
    Optional<Animal> getAnimalById(Long animalId);

    /**
     * Creates a new animal.
     *
     * @param animal The animal to create
     * @return The created animal
     */
    Animal createAnimal(Animal animal);

    /**
     * Updates an existing animal.
     *
     * @param animalId The ID of the animal to update
     * @param animalDetails The updated animal details
     * @return The updated animal, or null if not found
     */
    Animal updateAnimal(Long animalId, Animal animalDetails);

    /**
     * Deletes an animal by its ID.
     *
     * @param animalId The ID of the animal to delete
     */
    void deleteAnimal(Long animalId);

    /**
     * Retrieves all animals in a specific shelter.
     *
     * @param shelterId The ID of the shelter
     * @return List of animals in the specified shelter
     */
    List<Animal> getAnimalByShelter(Long shelterId);

    /**
     * Retrieves all animals of a specific species.
     *
     * @param species The species to search for
     * @return List of animals of the specified species
     */
    List<Animal> getAnimalBySpecies(String species);
}
