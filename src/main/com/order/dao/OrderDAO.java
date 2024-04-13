package main.com.order.dao;

import org.apache.ibatis.session.SqlSession;

public class OrderDAO {
	// 입력한 기업명의 고객 아이디 조회
    public int findClientId(SqlSession session, String company_name) {
        int clientId = session.selectOne("mapper.order.findClientId", company_name);
       
        return clientId;
    }
}
