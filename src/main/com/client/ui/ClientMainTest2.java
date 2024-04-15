package main.com.client.ui;

import org.apache.ibatis.session.SqlSession;

import main.com.client.dto.ClientDTO;
import main.com.config.MySqlSessionFactory;

public class ClientMainTest2 {

	public static void main(String[] args) {	
		
		SqlSession session = MySqlSessionFactory.openSession();
		
		//id를 통한 고객기업 조회
		
		ClientDTO dto3 = session.selectOne("main.resource.mapper.ClientMapper.findId", 41);
      System.out.println(dto3);
		
		
		//고객기업 등록
		/*
		ClientDTO dto = new ClientDTO(122, "dd", "ss", 12, "dd");
		session.insert("main.resource.mapper.ClientMapper.insert", dto);
		session.commit();
         System.out.println(dto);
         
         
         //정보 수정          
        ClientDTO dto2 = new ClientDTO();  
        dto2.setCategory("안녕");
        dto2.setId(122);
        session.update("main.resource.mapper.ClientMapper.update", dto2);
        session.commit();
        System.out.println(dto2);
        */
        
	}

}
