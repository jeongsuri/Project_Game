package org.choongang.score.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rank {
    private int RANK;
    private int MAX_SCORE;
    private String USER_ID;
}
