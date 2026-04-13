package com.ahilya.vote.AhilyaVote.services;

import com.ahilya.vote.AhilyaVote.model.OptionVote;
import com.ahilya.vote.AhilyaVote.model.Poll;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.ahilya.vote.AhilyaVote.repositories.PollRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

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
    public List<Poll> getAllPolls(){
        return pollRepository.findAll();
    }
    public Optional<Poll> getPollById(Long id){
      return pollRepository.findById(id);
    }
    @Transactional
    public void vote(Long pollId, int optionIndex){
        // get the poll from db
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        // get All options
        List<OptionVote>options = poll.getOptions();

        // if index for vote is not valid, throw error
       if(optionIndex < 0 || optionIndex >= options.size()){
          throw new IllegalArgumentException("Invalid option index");
       }

       // get Selected Option
       OptionVote selectedOption = options.get(optionIndex);

        // increment the vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // save incremented option into the database
        pollRepository.save(poll);

    }
}
