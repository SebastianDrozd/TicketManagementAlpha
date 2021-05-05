package com.example.srankoin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Ticket Data Transfer Object
public class TicketFakeDTO {

    private String title;

    private String issueType;

    private String priority;

    private Instant dateCreated;

    private String description;

    private int customerId;

    private String employee;
}
