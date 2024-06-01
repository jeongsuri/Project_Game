package org.choongang.game.controllers;
import org.choongang.game.entities.GamePlay;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
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
        while(true) {
            System.out.print("가위바위보 : ");
            me = sc.nextInt();
            you = rd.nextInt(3) + 1;
            GamePlay form = new GamePlay(me, you, score, 0);// 사용자가 입력한 값을 담는 역할 <- 사용자 요청 데이터
            try {
                Service service = new GameServiceLocator().find(Menu.GAME);
                service.process(form);
                break;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("1,2,3만 입력하세요. ");
            }
            System.out.println(form.getScore() + "점");
        }

        Router router = MainRouter.getInstance();
        router.change(Menu.JOIN);

    }
}