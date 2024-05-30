package org.choongang.game.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.game.entities.GameScore;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.Router;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;

import java.util.Scanner;

public class ScoreController { // 점수 저장 여부 -> y/n | y -> 점수 조회 & 메인 페이지 , n -> 메인 페이지
    private SqlSession session = DBConn.getSession(); // session = 데이터베이스 연결

    public void SaveScore(int score) { // saveScore -> 점수 저장 여부 + 저장
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 저장하시겠습니까? (예 : y / 아니오 : n) "); // 저장 여부 질문
        String response = scanner.nextLine(); // y / n 의 응답 -> response 변수에 저장
    /*
        if (response.equalsIgnoreCase("y")) {
            try {
                GameMapper mapper = session.getMapper(GameMapper.class);
                GameScore scores = GameScore.builder()
                        .userId("")
                        .score(score)
                        .build();
                int cnt = mapper.insertScore(scores);
                if (cnt > 0) {
                    System.out.println("점수 저장을 완료했습니다.");
                } else {
                    System.out.println("점수 저장을 실패했습니다.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else { // n 를 선택한 경우
            System.out.println("점수 저장을 선택하지 않았습니다.");
        }

        Router router = MainRouter.getInstance(); // 사용자 응답에 관계없이 메인 페이지로 이동
        router.change(Menu.MAIN); */
    }
}