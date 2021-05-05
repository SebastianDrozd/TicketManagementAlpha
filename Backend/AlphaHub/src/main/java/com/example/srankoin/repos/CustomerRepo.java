package com.example.srankoin.repos;

import com.example.srankoin.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//Create the Customer Repository

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
