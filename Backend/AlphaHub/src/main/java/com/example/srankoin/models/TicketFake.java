package com.example.srankoin.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

//Ticket Entity class
public class TicketFake {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String title;

    private String issueType;

    private String priority;

    private Instant dateCreated;

    private String description;

    private String employee;

    @ManyToOne
    @JsonIgnoreProperties("tickets")
    private Customer customer;

    public List<TicketMessage> getTicketMessageList() {
        return ticketMessageList;
    }

    @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<TicketMessage> ticketMessageList;









}
