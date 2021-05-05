package com.example.srankoin.controllers;
import com.example.srankoin.models.Reminder;
import com.example.srankoin.services.ReminderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class ReminderController {

    private final ReminderService reminderService; //declare the reminder service

    public ReminderController(ReminderService reminderService) { //inject the reminder service
        this.reminderService = reminderService;
    }

    //get request handler. grab all reminders
    @GetMapping("/Reminders")
    public ResponseEntity<?> getTickets(){
        List<Reminder> reminders = reminderService.getAllReminders();
        System.out.println(reminders);
        return ResponseEntity.ok(reminders);
    }

    //delete reminder by id
    @GetMapping("/Reminders/{id}")
    public @ResponseBody
    void deleteReminder(@PathVariable int id){
        System.out.println("The id is" + id);
        reminderService.deleteReminder(id);
    }

    //Post request handler for creating new Reminder
    @PostMapping("/Reminders/add")
    public @ResponseBody  Reminder newTicket(@RequestBody Reminder newReminder ){
        return reminderService.saveReminder(newReminder);
    }
}
