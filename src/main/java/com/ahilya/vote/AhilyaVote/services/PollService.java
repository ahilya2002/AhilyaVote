package com.ahilya.vote.AhilyaVote.services;

import com.ahilya.vote.AhilyaVote.model.Poll;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.ahilya.vote.AhilyaVote.repositories.PollRepository;

@Service

public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }
  @Transactional
    public Poll createPoll(Poll poll){
        return pollRepository.save(poll);
    }

}
