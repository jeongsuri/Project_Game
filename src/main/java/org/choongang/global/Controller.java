package org.choongang.global;

public interface Controller { // 제일 중요한 메서드 2개 정의
    void show();  // 서비스(Model)와 뷰를 연결
    void run();
}
/**
 * show()메서드 는 각 컨트롤러에 구체적인 서비스또는 모델과 뷰를 연결하는
 * 로직을 구현한다.
 *  run()메서드 는 각 컨트롤러가 실행될때 호출되는 메서드입니다.
 */
