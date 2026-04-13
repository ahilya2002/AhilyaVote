package com.ahilya.vote.AhilyaVote.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionVote {
   private String optionText;
   private int voteCount ;
}
