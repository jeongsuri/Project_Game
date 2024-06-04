package org.choongang.global;

import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.session.MemberSession;
import org.choongang.template.Templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
//추상 클래스 사용으로 재사용성과 확장성을 높였다.
public abstract class AbstractController implements Controller {

    protected Scanner sc;
    protected Random rd;
    protected List<String> items;


    public AbstractController() {
        sc = new Scanner(System.in);
        rd = new Random();
        items = new ArrayList<>();
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {
        System.out.println("묵찌빠 게임");
        System.out.println(Templates.getInstance().doubleLine());
    }

    /**
     * 입력 항목
     *  - 문자: q, exit, quit - 종료
     *  - 숫자: 메뉴 항목
     */
    public void prompt() {
        System.out.print("메뉴 선택: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("종료 합니다.");
            System.exit(0); // 0 - 정상 종료, 1 - 비정상 종료
        }

        try {
            int m = Integer.parseInt(menu);
            change(m); // 메뉴 변경
        } catch (Exception e) {
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    /**
     * 입력과 검증을 함께 진행
     * @param message : 항목 메세지
     * @param prdicate : 판별식
     */

    protected String promptWithValidation(String message, Predicate<String> prdicate){ // 공유 자원 (추상 -> 설계 + 공통)
        String str = null; // 입력받으면 검증 과정 무조건 거쳐야 함 매개변수가 함수형 인터페이스 (열린 기능 -> 각각 조건이 다르기 때문)
        do {                                                       // 쓴 이유 -> 사용자 정의 기능이기 때문에
            System.out.print(message);
            str = sc.nextLine();
        } while(!prdicate.test(str)); // do ~ while : 1번 입력 -> 판별 하는 과정

        return str;
    }

    protected int games(String message){
        String str = null;
        System.out.print(message);
        str = sc.nextLine();

        return Integer.parseInt(str) - 1;
    }

    protected int scores(String message){
        String str = null;
        System.out.print(message);
        str = sc.nextLine();

        return Integer.parseInt(str) - 1;
    }

    /**
     * 템플릿 메서드 패턴 : 특정 절차가 고정되어 있는 경우
     *
     */
    @Override
    public final void run() { // run() 하면 동일한 절차로 실행되므로 final 로 정의
        common(); // 공통 -> 항상 나오는 상단 쪽에 나오는 부분
        show(); // 실제 AbstractController 를 상속받은 하위 클래스의 각각 다른 부분
        prompt(); // 실제 보이는 부분
    }
      //메뉴 변경 처리
    private void change(int menuNo) { // 공통 입력 내용
        Menu menu = null;
        if (MemberSession.isLogin()) {
            switch (menuNo) {
                case 1: menu = Menu.GAME; break;
                case 2: menu = Menu.RANK; break;
                case 3:
                    MemberSession.logout();
                    menu = Menu.MAIN;
                    break;
            }
        } else {
            switch (menuNo) {
                case 1:
                    menu = Menu.JOIN;
                    break; // 회원가입
                case 2:
                    menu = Menu.LOGIN;
                    break; // 로그인
                default:
                    menu = Menu.MAIN; // 메인 메뉴
            }
        }




        // 메뉴 컨트롤러 변경 처리 - Router
        MainRouter.getInstance().change(menu);
    }
}
