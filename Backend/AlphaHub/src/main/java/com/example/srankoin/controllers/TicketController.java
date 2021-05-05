package com.example.srankoin.controllers;

import com.example.srankoin.models.TicketFake;
import com.example.srankoin.models.TicketFakeDTO;
import com.example.srankoin.models.UpdateTicket;
import com.example.srankoin.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tickets")
public class TicketController {

    private final TicketService ticketService; //declare the ticket service

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    //inject the ticketservice

    //get mapping handler to get all tickets
    @GetMapping
    public ResponseEntity<?> getAllTickets(){
        List<?> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    //get mapping handler to delete by id
    @GetMapping( "/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteTicket(@PathVariable int id){
        System.out.println("The id is" +id);
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Deleted ticket " + id);
    }

    //post mapping handler to create new ticket
    @PostMapping()
    TicketFake newTicket(@RequestBody TicketFakeDTO ticketFake) {
        return ticketService.saveTicket(ticketFake);
    }

    //put mapping handler to edit ticket
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateTicket updatedTicket, @PathVariable int id)  {
        ticketService.editTicket(updatedTicket,id);
        return ResponseEntity.ok("ok");

    }
}
