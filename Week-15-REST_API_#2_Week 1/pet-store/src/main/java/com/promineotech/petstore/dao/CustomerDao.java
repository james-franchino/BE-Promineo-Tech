package com.promineotech.petstore.dao;

import com.promineotech.petstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
