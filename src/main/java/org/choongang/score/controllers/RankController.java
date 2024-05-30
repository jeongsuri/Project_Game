package org.choongang.score.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.score.entities.Rank;
import org.choongang.score.entities.Score;
import org.choongang.score.mapper.ScoreMapper;
import org.choongang.template.Templates;

import java.util.List;

public class RankController extends AbstractController {


    @Override
    public void show() {
        return;
    }

    @Override
    public void prompt() {
        Templates.getInstance().render(Menu.RANK);
        SqlSession session = null;

        try {
            System.out.println("1. 전체랭킹");
            System.out.println("2. 개인랭킹");
            String choice = scoremessage("메뉴 선택: ");

            session = DBConn.getSession(); // SqlSession 생성

            switch (choice) {
                case "1":
                    System.out.println("전체랭킹");
                    // 전체랭킹 보여주는 창
                    List<Score> ranks = session.selectList("org.choongang.score.mapper.ScoreMapper.getScore2");
                    for (int i = 0; i < ranks.size(); i++) {
                        System.out.printf("%d등: %s/%d점%n", i+1, ranks.get(i).getUSER_ID(), ranks.get(i).getSCORE());
                    }
                    break;
                case "2":
                    System.out.println("개인랭킹");
                    // 개인랭킹 보여주는 창
                    ScoreMapper mapper = session.getMapper(ScoreMapper.class);
                    int score = mapper.getScoreOne("user01");
                    System.out.println("순위: " + score);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
