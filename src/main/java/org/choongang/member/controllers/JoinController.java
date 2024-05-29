package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

/**
 * 회원 가입 컨트롤러
 */

public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.JOIN);
    } // show() 에 정의

    @Override
    public void prompt() { // prompt 재정의 -> 하지 않으면 기본 값으로 나오기 때문에
       String userId = promptWithValidation("아이디(6자리 이상) : ", str -> str.length() >= 6);
        Router router2 = MainRouter.getInstance();
        /* try {

            if (!userId.equals(getId)) {
                System.out.println("사용 가능한 아이디입니다.");
            }
        } catch (RuntimeException e) {
            System.out.println("다른 아이디를 사용해주세요.");
            router2.change(Menu.MAIN);
        } */
       String userPw = promptWithValidation("비밀번호(8자리 이상) : ", s -> s.length() >= 8);
       String confirmPw = promptWithValidation("비밀번호 확인 : ", s -> { boolean match = s.equals(userPw);
           if(!match) {
               System.err.println("\n비밀번호가 일치 하지 않습니다.");
           }
           return match;
       });

       String userNm = promptWithValidation("회원명 : ", s -> !s.isBlank());

       RequestJoin form = RequestJoin.builder() // 사용자가 입력한 값을 담는 역할 <- 사용자 요청 데이터
               .userId(userId)
               .userPw(userPw)
               .confirmPw(confirmPw)
               .userNm(userNm)
               .build(); // 전달용 객체 DTO (why? 전달하기 위해서) -> 컨트롤러에 유입

        Router router = MainRouter.getInstance(); // 요기에 전달
       try {
           //회원 가입 처리..
           Service service = MemberServiceLocator.getInstance().find(Menu.JOIN);
           service.process(form);

           System.out.println("회원가입 성공했습니다.");

           //회원 가입 성공시 -> 로그인 화면
           router.change(Menu.LOGIN);

       }catch(RuntimeException e){
           //회원가입 실패시 -> 회원가입 화면으로 이동
           System.err.println(e.getMessage());
           System.out.println("다른 아이디를 입력하세요.");
           router.change(Menu.JOIN);
           //로그인 성공시 게임선택,랭킹조회 화면 이동

       }
    }
}

