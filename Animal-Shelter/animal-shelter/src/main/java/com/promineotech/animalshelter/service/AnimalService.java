package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Optional<Animal> getAnimalById(Long animalId);
    Animal createAnimal(Animal animal);
    Animal updateAnimal(Long animalId, Animal animalDetails);
    void deleteAnimal(Long animalId);
    List<Animal> getAnimalByShelter(Long shelterId);
    List<Animal> getAnimalBySpecies(String species);
}
