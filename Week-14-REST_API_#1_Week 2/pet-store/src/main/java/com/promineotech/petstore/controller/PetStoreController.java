package com.promineotech.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.promineotech.petstore.controller.model.PetStoreData;
import com.promineotech.petstore.service.PetStoreService;
import lombok.extern.slf4j.Slf4j;

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
}