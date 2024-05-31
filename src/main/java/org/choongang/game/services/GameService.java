package org.choongang.game.services;
import org.choongang.game.entities.GamePlay;
import org.choongang.global.Service;


public class GameService implements Service<GamePlay> {


    @Override
    public void process(GamePlay form) {
        if (form.getGamename().equals("가위바위보")) {
            if (form.getPlayer1() != form.getPlayer2()) {
                if (form.getPlayer1() + form.getPlayer2() * 2 == 1 || form.getPlayer1() + form.getPlayer2() * 2 == 4) { //가위바위보 이겼을때.
                    System.out.println("|  🧑‍💻  |  🖥  |");
                    System.out.println("|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  |");
                    System.out.println("이겼습니다. ");
                    form.setGamename("묵찌빠");
                    form.setWinner(1);


                } else {
                    System.out.println("|  🧑‍💻  |  🖥  |");
                    System.out.println("|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  |");
                    System.out.println("졌습니다.. ");
                    form.setGamename("묵찌빠");
                    form.setWinner(2);

                }
            } else {
                System.out.println("|  🧑‍💻  |  🖥  |");
                System.out.println("|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  |");
                System.out.println("비겼습니다.");
            }
        }else{
            if(form.getPlayer1() == form.getPlayer2()){
                System.out.println("|  🧑‍💻  |  🖥  |");
                System.out.println("|  " + form.getPlayer1() + "  |  " + form.getPlayer2() + "  |");
                switch(form.getWinner()){
                    case 1:
                        System.out.println("이겼습니다.");
                    case 2:
                        System.out.println("졌습니다.");
                }
            }else{
                form.setGamename("가위바위보");
            }
        }
    }
}


