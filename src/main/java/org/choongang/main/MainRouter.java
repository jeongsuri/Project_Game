package org.choongang.main;

import org.choongang.game.controllers.GameController;
import org.choongang.game.controllers.GameControllerLocator;
import org.choongang.game.controllers.ScoreController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;
import org.choongang.score.controllers.RankController;

public class MainRouter implements Router {

    /**
     * 싱글톤 패턴, 메뉴 컨트롤러가 변경될때마다 새로운 객체를 만들어지는것을 방지
     */
    private static Router instance;
    private MainRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new MainRouter();
        }
        return instance;
    }



    @Override
    public void change(Menu menu) {// change -> 라우터 인터페이스 안에 있는 변수
     //chage 메서드에서는 주어진 메뉴에 따라 해당하는 컨트롤러를 찾아 실행하는 기능을 수행합니다.
        ControllerLocator memlocator = MemberControllerLocator.getInstance();
        ControllerLocator gamelocator = GameControllerLocator.getInstance();
        Controller controller = null;
        switch (menu){
            case JOIN: controller = memlocator.find(Menu.JOIN); break;
            case LOGIN: controller = memlocator.find(Menu.LOGIN); break;
            case GAME: controller = gamelocator.find(Menu.GAME); break;
            //case SAVE: controller = gamelocator.find(Menu.SAVE); break;
            case SAVE: controller =  new ScoreController(); break;
            case RANK: controller = new RankController(); break;
            default: controller = new MainController();
        }
        controller.run(); //common(), show(), prompt()
    }
    //start()메서드는 무한루프를 통해 반복적으로 호출
     @Override
       public void start() {
        while(true){
          change(Menu.MAIN);
        }

    }
}
