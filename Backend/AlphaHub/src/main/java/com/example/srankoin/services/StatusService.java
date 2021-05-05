package com.example.srankoin.services;


import com.example.srankoin.models.Status;
import com.example.srankoin.models.UpdateStatus;
import com.example.srankoin.repos.StatusRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepo statusRepo; //declare the status repository

    //inject the status repository into the status service
    public StatusService(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }
    //method to get all statuses
    public List<Status> getAllStatus(){
        return statusRepo.findAll();
    }

    //method to save status
    public Status saveStatus(Status status){
       return statusRepo.save(status);
    }

    //method to editStatus
    public void editStatus(UpdateStatus status, int id){
        Optional<Status> statusReal = statusRepo.findById(id);
        statusReal.get().setMessage(status.getMessage());
        statusReal.get().setDate(status.getDate());
        statusReal.get().setEmployee(statusReal.get().getEmployee());
        statusRepo.save(statusReal.get());

    }
}