package com.example.srankoin.services;
import com.example.srankoin.models.Reminder;
import com.example.srankoin.repos.ReminderRepo;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReminderService {

    private final ReminderRepo reminderRepo; //declare the reminder repository

    //inject the reminder repository into the ReminderService
    public ReminderService(ReminderRepo reminderRepo) {
        this.reminderRepo = reminderRepo;
    }

    //method to get all Reminders
    public List<Reminder> getAllReminders(){
        return reminderRepo.findAll();
    }

    //method to delete a reminder by id
    public void deleteReminder(int id){
        reminderRepo.deleteById(id);
    }

    //method to save a reminder
    public Reminder saveReminder(Reminder reminder){
        return reminderRepo.save(reminder);
    }
}
