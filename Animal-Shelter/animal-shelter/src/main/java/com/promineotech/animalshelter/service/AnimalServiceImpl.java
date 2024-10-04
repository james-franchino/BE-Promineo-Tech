package com.promineotech.animalshelter.service;

import com.promineotech.animalshelter.dao.AnimalRepository;
import com.promineotech.animalshelter.dao.ShelterRepository;
import com.promineotech.animalshelter.entity.Animal;
import com.promineotech.animalshelter.entity.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> getAnimalById(Long AnimalId) {
        return animalRepository.findById(AnimalId);
    }

    @Override
    public Animal createAnimal(Animal animal) {
        if (animal.getShelter() != null && animal.getShelter().getShelterId() != null) {
            Optional<Shelter> shelter = shelterRepository.findById(animal.getShelter().getShelterId());
            shelter.ifPresent(animal::setShelter);
        }
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Long animalId, Animal animalDetails) {
        Optional<Animal> animal = animalRepository.findById(animalId);
        if (animal.isPresent()) {
            Animal existingAnimal = animal.get();
            existingAnimal.setName(animalDetails.getName());
            existingAnimal.setSpecies(animalDetails.getSpecies());
            existingAnimal.setBreed(animalDetails.getBreed());
            existingAnimal.setAge(animalDetails.getAge());
            existingAnimal.setGender(animalDetails.getGender());
            existingAnimal.setStatus(animalDetails.getStatus());
            existingAnimal.setIntakeDate(animalDetails.getIntakeDate());
            existingAnimal.setShelter(animalDetails.getShelter());
            return animalRepository.save(existingAnimal);
        }
        return null;
    }

    @Override
    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }

    @Override
    public List<Animal> getAnimalByShelter(Long shelterId) {
        return animalRepository.findByShelter_ShelterId(shelterId);
    }

    @Override
    public List<Animal> getAnimalBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }
}
