package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;

public class JoinService implements Service<RequestJoin> {

    @Override
    public void process(RequestJoin form) {
        SqlSession session = DBConn.getSession();
        String inputId = form.getUserId();
        /*String id = form.getUserId();
        String pw = form.getUserPw();
        String cpw = form.getConfirmPw();
        String nm = form.getUserNm();*/

        MemberMapper mapper = session.getMapper(MemberMapper.class);
        /*String dataId = mapper.getId(inputId);
         if (!dataId.equals(inputId))  {
            throw new RuntimeException();
        }*/
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(form.getUserPw())
                .userNm(form.getUserNm())
                .build();
        int cnt = mapper.register(member);
        //int cnt = session.insert("mappers.MemberMapper.register", member);

    }
}
