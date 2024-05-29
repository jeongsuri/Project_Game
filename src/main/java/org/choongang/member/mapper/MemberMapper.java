package org.choongang.member.mapper;

import org.choongang.member.entities.Member;


import java.util.List;

public interface MemberMapper {

    int plusMember(Member member);

    List<Member> getMember();

    String getPw (String userId);


    String getId (String userId);
    int register(Member member);

    Member get (String userId);
}

