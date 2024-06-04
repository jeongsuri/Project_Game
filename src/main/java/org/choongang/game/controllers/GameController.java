package org.choongang.game.controllers;
import org.choongang.game.entities.GamePlay;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.game.session.GameSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.session.MemberSession;
import org.choongang.template.Templates;


public class GameController extends AbstractController {

    @Override
    public void show() {
    }

    @Override
    public void prompt() {
        Templates.getInstance().render(Menu.GAME);
        GamePlay form = new GamePlay(0, 0, 0, 0);

        while(true) {
            System.out.print("가위바위보 : ");
            form.setPlayer1(sc.nextInt());
            form.setPlayer2(rd.nextInt(3) + 1);
            try {
                Service service = new GameServiceLocator().find(Menu.GAME);
                service.process(form);
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("1, 2, 3만 입력하세요. "); // 1, 2, 3 외에는 오류 발생
            }
            if(form.getWinner()==3){
                GameSession.setGamePlay(form);
                break;
            }
        }
        Router router = MainRouter.getInstance(); // 사용자 응답에 관계없이 메인 페이지로 이동
        router.change(Menu.SAVE);
    }

}