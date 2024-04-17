package main.com.config;

import main.com.member.domain.Member;

public class Session {
    private static Member loggedInMember;

    public static void setMember(Member member){
        loggedInMember = member;
    }

    public static Member getMember(){
        return loggedInMember;
    }

    public static void cleanSession(){
        loggedInMember = null;
    }
}
