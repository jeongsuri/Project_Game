package org.choongang.score.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {
    private int SCORE;
    private String USER_ID;
}
