package com.example.srankoin.services;

import com.example.srankoin.models.Customer;
import com.example.srankoin.repos.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo; //declare the customer repository

    //inject the customer repository
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    //method to getAllCustomers
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    //method to get customer by id
    public Customer findByIdentification(int id){
        return customerRepo.findById(id).get();
    }

    //method to save customer
    public void saveCustomer(Customer customer){
        customerRepo.save(customer);
    }



}
