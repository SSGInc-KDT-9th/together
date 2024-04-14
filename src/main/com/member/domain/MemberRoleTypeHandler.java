package main.com.member.domain;

import org.apache.ibatis.type.EnumTypeHandler;

public class MemberRoleTypeHandler extends EnumTypeHandler<MemberRole> {
    public MemberRoleTypeHandler() {
        super(MemberRole.class);
    }
}
