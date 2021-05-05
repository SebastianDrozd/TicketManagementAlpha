package com.example.srankoin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Update Status Data Transfer Object Class
public class UpdateStatus {

    private String message;
    private Instant date;
}
