package com.ahilya.vote.AhilyaVote.controllers;
import com.ahilya.vote.AhilyaVote.model.Poll;
import com.ahilya.vote.AhilyaVote.request.Vote;
import com.ahilya.vote.AhilyaVote.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {
   private final PollService pollService;
   //automatically unchecked service(spring manage component)
    @Autowired
    public PollController(PollService pollService){
        this.pollService = pollService;
    }
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        System.out.println("API recieved at rout");
        return pollService.createPoll(poll);
    }
    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

     @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id){
        return pollService.getPollById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
     }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}

