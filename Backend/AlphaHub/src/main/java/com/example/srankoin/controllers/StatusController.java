package com.example.srankoin.controllers;
import com.example.srankoin.models.Status;
import com.example.srankoin.models.UpdateStatus;
import com.example.srankoin.services.StatusService;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class StatusController {

    private final StatusService statusService; //decalre the statusService

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    //inject the statusService

    //get request handler to get all statuses
    @GetMapping("/Status")
    public ResponseEntity<?> getStatus(){
        List<Status> statuses = statusService.getAllStatus();
        return ResponseEntity.ok(statuses);
    }
    //post request handler to create new status
    @PostMapping("/Status")
    public Status postStatus(@RequestBody Status status){
        return statusService.saveStatus(status);
    }

    //put request handler to edit status
    @PutMapping("/Status/{id}")
    public void postStatus(@RequestBody UpdateStatus updateStatus, @PathVariable int id){
       statusService.editStatus(updateStatus,id);
    }
}
