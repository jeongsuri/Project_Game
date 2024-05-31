package org.choongang.game.controllers;
import org.choongang.game.entities.GamePlay;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;


public class GameController extends AbstractController {
    private int me;
    private int you;
    private int score = 0;



    @Override
    public void show() {
    }

    @Override
    public void prompt() {
        Templates.getInstance().render(Menu.GAME);
        String gamename = "가위바위보";
        while(true){
            System.out.print("가위바위보 : ");
            me = sc.nextInt() - 1;
            you = rd.nextInt(3);

            GamePlay form = new GamePlay(me, you, gamename, score,0);// 사용자가 입력한 값을 담는 역할 <- 사용자 요청 데이터
            while(true) {
                try {
                    if(form.getWinner() == 1){
                        System.out.println("공격차례입니다.");
                        System.out.print("묵찌빠 : ");
                        me = sc.nextInt() - 1;
                        you = rd.nextInt(3);
                    }else if(form.getWinner() == 2){
                        System.out.println("수비차례입니다.");
                        System.out.print("묵찌빠 : ");
                        me = sc.nextInt() - 1;
                        you = rd.nextInt(3);
                    }
                    Service service = GameServiceLocator.getInstance().find(Menu.GAME);
                    service.process(form);
                } catch (RuntimeException e) {
                    System.out.println("1,2,3만 입력하세요. ");
                }
                System.out.println(form.getScore() + "점");
            }
        }
    }
}