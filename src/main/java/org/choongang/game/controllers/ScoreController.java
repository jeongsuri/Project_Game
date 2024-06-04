package org.choongang.game.controllers;

import org.choongang.game.entities.GamePlay;
import org.choongang.game.entities.GameScore;
import org.choongang.game.services.GameServiceLocator;
import org.choongang.game.session.GameSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.entities.Member;
import org.choongang.member.session.MemberSession;
import org.choongang.template.Templates;

import java.util.Scanner;

public class ScoreController extends AbstractController { // 점수 저장 여부 -> y/n | y -> 점수 조회 & 메인 페이지 , n -> 메인 페이지
    Member member = MemberSession.getMember();
    GamePlay gamePlay = GameSession.getGamePlay();

    @Override
    public void common(){
        System.out.println(Templates.getInstance().doubleLine());
        System.out.println("묵찌빠 게임");
        System.out.println(Templates.getInstance().doubleLine());
    }

    @Override
    public void show() { // 최종 점수
        System.out.printf("%s(%s)님의 최종점수는 %d입니다.\n",member.getUserId(),member.getUserNm(),gamePlay.getScore());
        System.out.println(Templates.getInstance().line());
    }

    @Override
    public void prompt() {
        System.out.print("점수를 저장하시겠습니까? (예 : 1 / 아니오 : 2) : "); // 저장 여부 질문
        switch (sc.nextInt()){
            case 1:
                GameScore form = GameScore.builder()
                        .userId(member.getUserId())
                        .score(gamePlay.getScore())
                        .build();
                try{
                    Service service = new GameServiceLocator().find(Menu.SAVE);
                    service.process(form);
                    System.out.println("저장완료!"); // 저장이 된 경우
                }catch(RuntimeException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("점수 저장을 선택하지 않았습니다."); // 저장을 선택하지 않은 경우
                break;
        }
        Router router = MainRouter.getInstance(); // 사용자 응답에 관계없이 메인 페이지로 이동
        router.change(Menu.MAIN);
    }
}