package com.example.srankoin.services;
import com.example.srankoin.models.Customer;
import com.example.srankoin.models.TicketFake;
import com.example.srankoin.models.TicketFakeDTO;
import com.example.srankoin.models.UpdateTicket;
import com.example.srankoin.repos.CustomerRepo;
import com.example.srankoin.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    //autowired customer repository
    @Autowired
    CustomerRepo customerRepo;

    private final TicketRepo ticketRepo; //declare the ticket repository

    //inject the ticket repository into the ticket service
    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    //method to get all tickets
    public List<TicketFake> getAllTickets(){
        return ticketRepo.findAll();
    }

    //method to delete a ticket
    public void deleteTicket(int id){
        Optional<TicketFake> ticketFake = ticketRepo.findById(id);
        ticketFake.get().getCustomer().getTickets().remove(ticketFake.get());
        ticketFake.get().setCustomer(null);
        ticketRepo.delete(ticketFake.get());
    }

    //method to save ticket
    public TicketFake saveTicket(TicketFakeDTO ticketFake){
        Optional<Customer> customer = customerRepo.findById(ticketFake.getCustomerId());
        TicketFake ticketSave = new TicketFake();
        ticketSave.setTitle(ticketFake.getTitle());
        ticketSave.setIssueType(ticketFake.getIssueType());
        ticketSave.setPriority(ticketFake.getPriority());
        ticketSave.setDateCreated(ticketFake.getDateCreated());
        ticketSave.setDescription(ticketFake.getDescription());
        ticketSave.setEmployee(ticketFake.getEmployee());
        customer.get().getTickets().add(ticketSave);
        ticketSave.setCustomer(customer.get());
       return ticketRepo.save(ticketSave);


    }
    //method to edit ticket
    public void editTicket(UpdateTicket updatedTicket,int id){
        Optional<TicketFake> ticket = ticketRepo.findById(id);
        ticket.get().setTitle(updatedTicket.getTitle());
        ticket.get().setPriority(updatedTicket.getPriority());
        ticket.get().setIssueType(updatedTicket.getIssueType());
        ticket.get().setDescription(updatedTicket.getDescription());
        ticket.get().setEmployee(updatedTicket.getEmployee());
        ticketRepo.save(ticket.get());
    }


}
