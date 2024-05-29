package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.mapper.MemberMapper;

public class LoginService implements Service<RequestLogin> {


    @Override
    public void process(RequestLogin form) {
        SqlSession session = DBConn.getSession();
        String inputId = form.getUserId();
        String inputPw = form.getUserPw();

        MemberMapper mapper = session.getMapper(MemberMapper.class);
        String dataPw = mapper.getPw(inputId);  // 데이터베이스 PW 데이터 가져오기

        if (!dataPw.equals(inputPw)) {  // 데이터베이스의 PW, sc input 비교
            throw new RuntimeException();
        }
    }
}
