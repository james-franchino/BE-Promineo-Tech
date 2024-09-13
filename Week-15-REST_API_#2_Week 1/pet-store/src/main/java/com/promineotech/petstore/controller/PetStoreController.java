package com.promineotech.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.promineotech.petstore.controller.model.PetStoreData;
import com.promineotech.petstore.service.PetStoreService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
    @Autowired
    private PetStoreService petStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Received request to create pet store: {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }

    @PutMapping("/{petStoreId}")
    public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
        petStoreData.setPetStoreId(petStoreId);
        log.info("Received request to update pet store with ID {}: {}", petStoreId, petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }

    @PostMapping("/{petStoreId}/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public PetStoreData.PetStoreEmployee addEmployee(@PathVariable Long petStoreId,
                                                     @RequestBody PetStoreData.PetStoreEmployee employee) {
        log.info("Received request to add employee to pet store ID: {}", petStoreId);
        return petStoreService.saveEmployee(petStoreId, employee);
    }

    @GetMapping
    public List<PetStoreData> getAllPetStores() {
        log.info("Received request to list all pet stores");
        return petStoreService.retrieveAllPetStores();
    }

    @GetMapping("/{petStoreId}")
    public PetStoreData getPetStoreById(@PathVariable Long petStoreId) {
        log.info("Received request to get pet store with ID: {}", petStoreId);
        return petStoreService.retrievePetStoreById(petStoreId);
    }

    @DeleteMapping("/{petStoreId}")
    public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
        log.info("Received request to delete pet store with ID: {}", petStoreId);
        petStoreService.deletePetStoreById(petStoreId);
        return Map.of("message", "Pet store with ID=" + petStoreId + " was deleted successfully.");
    }

    @PostMapping("/{petStoreId}/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public PetStoreData.PetStoreCustomer addCustomer(@PathVariable Long petStoreId,
                                                     @RequestBody PetStoreData.PetStoreCustomer customer) {
        log.info("Received request to add customer to pet store ID: {}", petStoreId);
        return petStoreService.saveCustomer(petStoreId, customer);
    }

}