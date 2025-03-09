package com.ahilya.vote.AhilyaVote.controllers;

import com.ahilya.vote.AhilyaVote.model.Poll;
import com.ahilya.vote.AhilyaVote.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/polls")
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

}
