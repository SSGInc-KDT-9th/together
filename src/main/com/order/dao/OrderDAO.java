package main.com.order.dao;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

public class OrderDAO {
	// 입력한 기업명의 고객 아이디 조회
    public int findClientId(SqlSession session, String company_name) {
//        int clientId = session.selectOne("mapper.order.findClientId", company_name);
//        return clientId;
    	int clientId = 0;
        try {
            clientId = session.selectOne("mapper.order.findClientId", company_name);
        } catch (NullPointerException e) {
            // 등록되지 않은 기업에 대한 예외 처리
            JOptionPane.showMessageDialog(null, "등록된 기업이 아닙니다.", "경고", JOptionPane.WARNING_MESSAGE);
            
//            e.printStackTrace();
        }
        return clientId;
    }
    
    //입력학 상품의 상품 아이디 조회
    public int findProductId(SqlSession session, String product_name) {
    	int productId = session.selectOne("mapper.order.findProductId", product_name);
    	return productId;
    }
}
