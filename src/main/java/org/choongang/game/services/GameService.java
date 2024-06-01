package org.choongang.game.services;
import org.choongang.game.entities.GamePlay;
import org.choongang.global.Service;

import java.util.ArrayList;
import java.util.List;


public class GameService implements Service<GamePlay> {


    @Override
    public void process(GamePlay form) {
        switch (form.getPlayer2() -  form.getPlayer1()){
            case 2: case -1: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 이겼습니다.\n"); break;
            case 0: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 비겼습니다.\n"); break;
            default: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 졌습니다.\n"); break;
        }
    }
}


