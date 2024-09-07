package com.promineotech.petstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.petstore.dao.PetStoreDao;
import com.promineotech.petstore.controller.model.PetStoreData;
import com.promineotech.petstore.entity.PetStore;
import java.util.NoSuchElementException;

@Service
public class PetStoreService {
    @Autowired
    private PetStoreDao petStoreDao;

    public PetStoreData savePetStore(PetStoreData petStoreData) {
        Long petStoreId = petStoreData.getPetStoreId();
        PetStore petStore = findOrCreatePetStore(petStoreId);
        copyPetStoreFields(petStore, petStoreData);

        PetStore savedPetStore = petStoreDao.save(petStore);
        return new PetStoreData(savedPetStore);
    }

    private PetStore findOrCreatePetStore(Long petStoreId) {
        if (petStoreId == null) {
            return new PetStore();
        } else {
            return findPetStoreById(petStoreId);
        }
    }

    private PetStore findPetStoreById(Long petStoreId) {
        return petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException("Pet store not found with ID: " + petStoreId));
    }

    private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
        petStore.setPetStoreName(petStoreData.getPetStoreName());
        petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
        petStore.setPetStoreCity(petStoreData.getPetStoreCity());
        petStore.setPetStoreState(petStoreData.getPetStoreState());
        petStore.setPetStoreZip(petStoreData.getPetStoreZip());
        petStore.setPetStorePhone(petStoreData.getPetStorePhone());
    }
}
