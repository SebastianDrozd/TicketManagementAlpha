package com.example.srankoin.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Ticket Data Transfer Object Class
@SequenceGenerator(name="seq", initialValue = 1, allocationSize = 100)
public class UpdateTicket {

    private String title;

    private String issueType;

    private String priority;

    private String description;

    private String employee;



}
