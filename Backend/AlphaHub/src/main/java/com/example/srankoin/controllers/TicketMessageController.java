package com.example.srankoin.controllers;

import com.example.srankoin.models.TicketMessage;
import com.example.srankoin.services.TicketMessageService;
import com.example.srankoin.services.TicketMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/TicketMessage")
public class TicketMessageController {

    private final TicketMessageService ticketMessageService; //declare the ticketMessageService

    //inject the ticketMessageService
    public TicketMessageController(TicketMessageService ticketMessageService) {
        this.ticketMessageService = ticketMessageService;
    }


    //get mapping handler to get all ticketMessages
    @GetMapping
    public ResponseEntity<?> getAllMessages(){
        List<?> messages = ticketMessageService.getAllTicketMessage();
        return ResponseEntity.ok(messages);
    }

    //put mapping handler to edit ticketmessage
    @PutMapping("/{id}")
    void setMessage(@RequestBody TicketMessage ticketMessage, @PathVariable int id){
            ticketMessageService.saveTicketMessage(ticketMessage,id);
    }

    //delete request mapping handler to delete ticketmessage by id
    @DeleteMapping("/{id}")
    void deleteTicketMessage(@PathVariable int id){
        ticketMessageService.deleteTicketMessage(id);
    }
}
