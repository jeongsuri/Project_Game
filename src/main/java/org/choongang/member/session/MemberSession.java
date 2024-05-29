package org.choongang.member.session;


import org.choongang.member.entities.Member;

public class MemberSession {
    private static Member member;

    public static void setMember(Member member) {
        MemberSession.member = member;
    }

    public static Member getMember() {
        return member;
    }

    public static boolean isLogin() {
        return member != null;
    }
}
