package org.choongang.game.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.game.entities.GamePlay;
import org.choongang.game.entities.GameScore;
import org.choongang.game.mapper.GameMapper;
import org.choongang.game.services.GameService;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.controllers.LoginController;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

import java.util.ArrayList;
import java.util.Random;

public class GameController extends AbstractController {
    private SqlSession session = DBConn.getSession();
    private Random random = new Random();
    private int me;
    private int you;
    private int gamescore = 0;



    @Override
    public void show() {
    }

    @Override
    public void prompt() {
        Templates.getInstance().render(Menu.GAME);
        ArrayList<String> p1 = new ArrayList<>();
        p1.add("✌️");
        p1.add("✊");
        p1.add("✋");


        while(true){
            System.out.print("가위바위보");
            me = sc.nextInt() - 1;
            you = random.nextInt(3);
            GamePlay form = GamePlay.builder()
                    .player1(me)
                    .player2(you)
                    .build();
            try {
                //회원 가입 처리..
                Service service = GameServiceLocator.getInstance().find(Menu.GAME);
                service.process(form);
                System.out.println(form);

            }catch(RuntimeException e){

                System.out.println("오류");


            }
        }


        /*
        outerLoop:
        while (true) {
            me = games("가위바위보 : ");
            you = random.nextInt(3);
            System.out.println("|  🧑‍💻  |  🖥  |");
            System.out.println("|  " + p1.get(me) + "  |  " + p1.get(you) + "  |");
            while (true) {
                if (me != you) {
                    if (me + you * 2 == 1 || me + you * 2 == 4) { //가위바위보 이겼을때.
                        System.out.println("공격차례입니다.");
                        me = games("묵찌빠 : ");
                        you = random.nextInt(3);
                        System.out.println("|  🧑‍💻  |  🖥  |");
                        System.out.println("|  " + p1.get(me) + "  |  " + p1.get(you) + "  |");
                        if (me == you) { //묵찌빠 이겼을떄
                            gamescore++;
                            System.out.printf("이겼습니다. %d점\n", gamescore);
                            break;
                        }
                    } else {
                        System.out.println("수비차례입니다.");
                        me = games("묵찌빠 : ");
                        you = random.nextInt(3);
                        System.out.println("|  🧑‍💻  |  🖥  |");
                        System.out.println("|  " + p1.get(me) + "  |  " + p1.get(you) + "  |");
                        if (me == you) {
                            System.out.println("졌습니다.");
                            System.out.printf("최종점수 %d점\n", gamescore);
                            break outerLoop;
                        }
                    }
                }
                else {
                    System.out.println("비겼습니다.");
                    break;
                }
            }
        }

        Router router = MainRouter.getInstance();

        try{
            GameMapper mapper = session.getMapper(GameMapper.class);
            GameScore scores = GameScore.builder()
                    .userId(LoginController.loginId)
                    .score(gamescore)
                    .build();
            int cnt = mapper.insertScore(scores);
            System.out.println("점수저장완료");
            router.change(Menu.MAIN);
        }catch(Exception e){
            e.printStackTrace();
            router.change(Menu.MAIN);
        }

         */



    }

}


