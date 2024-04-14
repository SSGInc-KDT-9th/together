package main.com.client.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.client.service.ClientService;
import main.com.client.service.ClientServiceImpl;

public class ClientMainTest {

	public static void main(String[] args) {
		ClientService service = new ClientServiceImpl();
		service.setDao(new ClientDAO());
        Scanner scan  = new Scanner(System.in);
        
		while(true) {
			System.out.println("1. 전체목록");
			System.out.println("2. 기업삭제");
			System.out.println("3. 기업저장");
			System.out.println("0. 종료");
			System.out.println("-------------------");
			String num = scan.next();
			if("1".equals(num)) {
               List<ClientDTO> list = service.findAll();
                 for (ClientDTO e : list) {
	               System.out.println(e);
                    }
			}else if("2".equals(num)) {
				
				System.out.println("삭제할 기업id를 입력하세요.");
				String id = scan.next();
                int n = service.removeByid(Integer.parseInt(id));
                System.out.println(n+" 개가 삭제됨.");
			        
				
			}else if("0".equals(num)) {
				System.out.println("프로그램 종료됨.");
				System.exit(0);
			}
		}
	
		
		 
         
	}

}
