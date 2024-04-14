package main.com.client.ui;

import org.apache.ibatis.session.SqlSession;

import main.com.client.dto.ClientDTO;
import main.com.config.MySqlSessionFactory;

public class ClientMainTest2 {

	public static void main(String[] args) {	
		
		
	
		SqlSession session = MySqlSessionFactory.openSession();
		
		
		
		ClientDTO dto = new ClientDTO(0, "dd", "ss", 12, "dd");
		session.insert("main.resource.mapper.ClientMapper.insert", dto);
		session.commit();
         System.out.println(dto);
         
         
         
	}

}
