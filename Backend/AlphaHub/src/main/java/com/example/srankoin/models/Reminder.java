package com.example.srankoin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//Main Reminder Entity class
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String message;

    String date;

    String createdBy;

    private Instant dateCreated;
}
