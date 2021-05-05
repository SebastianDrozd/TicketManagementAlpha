package com.example.srankoin.repos;

import com.example.srankoin.models.TicketFake;
import org.springframework.data.jpa.repository.JpaRepository;

//Create the Ticket Repository
public interface TicketRepo extends JpaRepository<TicketFake, Integer> {
}
