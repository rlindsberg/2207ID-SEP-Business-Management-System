package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Request;
import com.SEP.BusinessManagementSystem.Entity.Subteam;
import com.SEP.BusinessManagementSystem.Entity.Task;
import com.SEP.BusinessManagementSystem.Service.SubteamService;
import com.SEP.BusinessManagementSystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/subteams")
public class SubteamController {
    private final SubteamService subteamService;

    @Autowired
    public SubteamController(SubteamService subteamService) {
        this.subteamService = subteamService;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSubteamById(@PathVariable Long id){
        return ResponseEntity.ok().body(subteamService.getSubteamById(id));
    }

//    @GetMapping("/get-all")
//    public List<Subteam> getAllSubteams() {
//        return subteamService.getAllSubteams();
//    }
//

    // do we need to create a subteam?
    @PostMapping("/create/{id}")
    public ResponseEntity<?> createNewSubteam(@PathVariable Long id, @RequestBody Subteam subteamDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("subteams/create").toUriString());
        return ResponseEntity.created(uri).body(subteamService.createNewSubteam(id, subteamDetails));
    }
}
