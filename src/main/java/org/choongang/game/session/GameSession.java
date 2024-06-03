package org.choongang.game.session;

import org.choongang.game.entities.GamePlay;

public class GameSession {
    private static GamePlay gamePlay;

    public static void setGamePlay(GamePlay gamePlay) {
        GameSession.gamePlay = gamePlay;
    }

    public static GamePlay getGamePlay() {
        return gamePlay;
    }
}
