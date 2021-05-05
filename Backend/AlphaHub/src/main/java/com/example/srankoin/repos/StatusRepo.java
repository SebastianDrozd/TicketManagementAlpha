package com.example.srankoin.repos;

import com.example.srankoin.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Create the status repository
@Repository
public interface StatusRepo extends JpaRepository<Status,Integer> {
}
