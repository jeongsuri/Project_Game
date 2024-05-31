package org.choongang.game.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GamePlay {
    private int player1 ;
    private int player2 ;
    private String gamename;
    private int score;
    private int winner;
}
