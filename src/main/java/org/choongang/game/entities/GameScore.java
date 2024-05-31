package org.choongang.game.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameScore {
    private String userId ;
    private int score;
}
