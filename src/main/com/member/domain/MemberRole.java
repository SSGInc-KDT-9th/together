package main.com.member.domain;

public enum MemberRole{
    ADMIN(1),
    COMMON(2);

    private final int roleStatus;

    MemberRole(int roleStatus) {
        this.roleStatus = roleStatus;
    }

    public int getRoleStatus() {
        return roleStatus;
    }
}
