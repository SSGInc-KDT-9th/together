package main.com.member.domain;


public class Member {
    private Long id;
    private String member_name;
    private String member_login_id;
    private String member_password;
    private MemberRole member_role;

    public Member(String member_name, String member_login_id, String member_password, MemberRole member_role) {
        this.member_name = member_name;
        this.member_login_id = member_login_id;
        this.member_password = member_password;
        this.member_role = member_role;
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_login_id() {
        return member_login_id;
    }

    public String getMember_password() {
        return member_password;
    }

    public MemberRole getMember_role() {
        return member_role;
    }
}