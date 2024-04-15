package main.com.order.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import main.com.order.dto.OrderDTO;
import main.com.release.dto.ReleaseDTO;

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
    	int productId = 0;
    	
    	 try {
    		 productId = session.selectOne("mapper.order.findProductId", product_name);
         } catch (NullPointerException e) {
             // 등록되지 않은 기업에 대한 예외 처리
             JOptionPane.showMessageDialog(null, "없는 상품입니다.", "경고", JOptionPane.WARNING_MESSAGE);
             
//             e.printStackTrace();
         }
    	return productId;
    }
    public int enrolltoorder(SqlSession session, OrderDTO dto) {
		 return session.insert("mapper.order.enrolltoorder", dto);
	 }
    
    public List<OrderDTO> orderselect(SqlSession session, long id){
		List<OrderDTO> list = 
				session.selectList("mapper.order.orderselect", id);
		return list;
	}
    
    
    //입력한 상품아이디의 상품명 조회
    public String productselect(SqlSession session, int id) {
    	String pname = session.selectOne("mapper.order.productselect", id);
    	return pname;
    }
    //입력한 기업 아이디의 기업명 조회
    public String companyselect(SqlSession session, int id) {
    	String cname = session.selectOne("mapper.order.companyselect", id);
    	return cname;
    }
   //주문 삭제
    public int orderdelete(SqlSession session, int id) {
    	return session.delete("mapper.order.orderdelete", id);
    }
}
