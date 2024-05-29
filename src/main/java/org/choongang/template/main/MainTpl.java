package org.choongang.template.main;

import org.choongang.member.entities.Member;
import org.choongang.member.session.MemberSession;
import org.choongang.template.Template;
import org.choongang.template.Templates;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("메뉴를 선택하세요. \n");

        if (MemberSession.isLogin()) {
            Member member = MemberSession.getMember();

            System.out.printf("%s(%s)님 로그인 하셨습니다.%n", member.getUserNm(), member.getUserId());

        } else {
            sb.append("1. 회원가입\n");
            sb.append("2. 로그인\n");
        }
        sb.append("3. 게임선택\n");
        sb.append("4. 랭킹조회\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}
