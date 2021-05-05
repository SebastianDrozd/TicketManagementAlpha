package com.example.srankoin.repos;

import com.example.srankoin.models.TicketMessage;
import org.springframework.data.jpa.repository.JpaRepository;

//Create the TicketMessage Repository
public interface TicketMessageRepo extends JpaRepository<TicketMessage,Integer> {
}
