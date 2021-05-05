package com.example.srankoin.services;

import com.example.srankoin.models.TicketFake;
import com.example.srankoin.models.TicketMessage;
import com.example.srankoin.repos.TicketMessageRepo;
import com.example.srankoin.repos.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketMessageService {

    private final TicketRepo ticketRepo; // declare a ticket repository

    private final TicketMessageRepo ticketMessageRepo; //declare a ticketmessage Repository

    //inject the ticket repository and the ticketmessage repository in to the
    public TicketMessageService(TicketRepo ticketRepo, TicketMessageRepo ticketMessageRepo) {
        this.ticketRepo = ticketRepo;
        this.ticketMessageRepo = ticketMessageRepo;
    }

    //method to grab all ticket messages
    public List<?> getAllTicketMessage(){
        return ticketMessageRepo.findAll();
    }

    //method to save a ticketmessage
    public void saveTicketMessage(TicketMessage ticketMessage, int id){
        System.out.println(id);
        Optional<TicketFake> ticketFake = ticketRepo.findById(id);
        ticketFake.get().getTicketMessageList().add(ticketMessage);
        ticketMessage.setTicketFake(ticketFake.get());
        ticketMessageRepo.save(ticketMessage);
        ticketRepo.save(ticketFake.get());
    }

    //method to delete ticket message
    public void deleteTicketMessage(int id){
        ticketMessageRepo.deleteById(id);
    }

}
