package org.choongang.game.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.game.entites.GameScore;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.controllers.LoginController;
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

        // 게임 종료 후 점수 저장 여부 묻기
        ScoreController scoreController = new ScoreController();
        scoreController.SaveScore(gamescore);
    }
}