package org.choongang.game.services;
import org.choongang.game.controllers.GameController;
import org.choongang.game.entities.GamePlay;
import org.choongang.global.Service;

import java.util.ArrayList;
import java.util.List;


public class GameService implements Service<GamePlay> {


    @Override
    public void process(GamePlay form) {
        switch(form.getWinner()){
            case 0:
                switch (form.getPlayer2() -  form.getPlayer1()){
                    case 2: case -1: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n이겼습니다. 공격차례입니다.\n"); form.setWinner(1); break; // 가위바위보 이긴 경우
                    case 0: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n비겼습니다. 다시 가위바위보 하세요.\n"); form.setWinner(0); break; // 가위바위보 비긴 경우 -> 다시 하기
                    default: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n졌습니다. 수비차례입니다.\n"); form.setWinner(2); break;
                    // 가위바위보 진 경우
                }
                break;
            case 1:
                switch (form.getPlayer2() -  form.getPlayer1()){
                    case 0: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n이겼습니다.\n");  form.setWinner(0); form.setScore(form.getScore()+1);
                        System.out.printf("현재 점수는 %d입니다.\n",form.getScore());break;
                    case 2: case -1: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n공격차례입니다.\n"); form.setWinner(1); break;
                    default: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n수비차례입니다.\n"); form.setWinner(2); break ;
                }
                break;
            case 2:
                switch (form.getPlayer2() -  form.getPlayer1()){
                    case 0: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 졌습니다. 게임을 종료하겠습니다.\n"); form.setWinner(3);  break;
                    case 2: case -1: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 공격차례입니다.\n"); form.setWinner(1); break;
                    default: System.out.print("|  🧑‍💻  |  🖥  |\n|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  | \n 수비차례입니다.\n"); form.setWinner(2);  break;
                }
                break;
        }
    }
}


