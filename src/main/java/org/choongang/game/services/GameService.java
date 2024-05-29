package org.choongang.game.services;

import org.choongang.game.entities.GamePlay;
import org.choongang.game.entities.GameScore;
import org.choongang.global.Service;

public class GameService implements Service<GameScore>{

    @Override
    public void process(GameScore form) {
        //System.out.println("|  🧑‍💻  |  🖥  |");
        //System.out.println("|  " + form.toString() + "  |  "  + "  |");
    }
}
