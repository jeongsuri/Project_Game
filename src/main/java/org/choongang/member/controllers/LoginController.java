package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    static String dataPw;
    public static String loginId;      // 로그인동안 사용할 사용자 ID

    @Override
    public void show() {
        Templates.getInstance().render(Menu.LOGIN);
    }

    @Override
    public void prompt() {
        String userId = promptWithValidation("아이디 : ", s -> !s.isBlank());
        loginId = userId;
        String userPw = promptWithValidation("비밀번호 : ", s -> !s.isBlank());

        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build();


        //로그인 처리...
        Router router = MainRouter.getInstance();
        try{
            Service service = MemberServiceLocator.getInstance().find(Menu.LOGIN);
            service.process(form);
            router.change(Menu.MAIN); // 로그인 성공시 -> 메인페이지
        }catch(RuntimeException e){
            String redBoldText = "\033[31;1m";      //오류 색깔 지정
            String resetText = "\033[0m";

            System.out.println(redBoldText + "\n아이디 또는 비밀번호가 잘못되었습니다. \n다시 시도하세요." + resetText);    // 로그인 실패 알림
            router.change(Menu.LOGIN); //로그인 실패시 -> 로그인페이지
        }

    }
}
