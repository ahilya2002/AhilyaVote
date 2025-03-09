package com.ahilya.vote.AhilyaVote.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;

    // wherever you use separate table JPA will create a separate table
    // it will create separate table with id and options
//    @ElementCollection
//    private List<OptionVote> options = new ArrayList<>();// allow us to create seperate table without creating sepearting entity

//    @ElementCollection
//    private List<Long> votes = new ArrayList<>();
}
