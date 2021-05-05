package com.example.srankoin.repos;

import com.example.srankoin.models.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

//Create the Reminder Repository
public interface ReminderRepo extends JpaRepository<Reminder, Integer> {
}

