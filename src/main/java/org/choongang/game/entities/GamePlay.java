package org.choongang.game.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GamePlay {
    private int player1 ;
    private int player2 ;
}
