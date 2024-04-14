package main.com.client.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.client.service.ClientService;
import main.com.client.service.ClientServiceImpl;

public class ClientMain extends JFrame {

	private JPanel contentPane;
	private JTextField insertid;
	private JTextField insertCompanyName;
	private JTextField tfid;
	private JTextField tfcompanyName;
	private JTextField tfcategory;
	private JTextField tfincome;
	private JTextField tfaddress;
	private JTextField deleteid;
	JButton btnsave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 프레임
	 */
	public ClientMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(915, 52, 339, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("기업명");
		lblNewLabel.setBounds(12, 71, 52, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("카테고리");
		lblNewLabel_1.setBounds(12, 105, 52, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("거래액");
		lblNewLabel_1_1.setBounds(12, 139, 52, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1.setBounds(12, 179, 41, 24);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBounds(12, 224, 91, 23);
		panel.add(btnNewButton_1);
		
		btnsave = new JButton("등록");
		btnsave.setBounds(224, 224, 91, 23);
		panel.add(btnsave);
		
		JLabel lblid = new JLabel("기업id");
		lblid.setBounds(12, 34, 52, 24);
		panel.add(lblid);
		
		tfid = new JTextField();
		tfid.setColumns(10);
		tfid.setBounds(76, 36, 178, 21);
		panel.add(tfid);
		
		tfcompanyName = new JTextField();
		tfcompanyName.setColumns(10);
		tfcompanyName.setBounds(76, 73, 178, 21);
		panel.add(tfcompanyName);
		
		tfcategory = new JTextField();
		tfcategory.setColumns(10);
		tfcategory.setBounds(76, 107, 178, 21);
		panel.add(tfcategory);
		
		tfincome = new JTextField();
		tfincome.setColumns(10);
		tfincome.setBounds(76, 141, 178, 21);
		panel.add(tfincome);
		
		tfaddress = new JTextField();
		tfaddress.setColumns(10);
		tfaddress.setBounds(76, 181, 239, 21);
		panel.add(tfaddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(915, 375, 339, 86);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("삭제할 기업 id를 입력하시오");
		lblNewLabel_1_1_1_1.setBounds(12, 10, 277, 15);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.setBounds(236, 53, 91, 23);
		panel_1.add(btnNewButton);
		
		deleteid = new JTextField();
		deleteid.setColumns(10);
		deleteid.setBounds(12, 35, 178, 21);
		panel_1.add(deleteid);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBounds(29, 66, 832, 430);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(815, 20, 17, 410);
		panel_2.add(scrollBar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(29, 10, 645, 50);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblid_1 = new JLabel("기업id");
		lblid_1.setBounds(26, 16, 52, 24);
		panel_3.add(lblid_1);
		
		JLabel lblNewLabel_2 = new JLabel("기업명");
		lblNewLabel_2.setBounds(293, 16, 52, 24);
		panel_3.add(lblNewLabel_2);
		
		insertid = new JTextField();
		insertid.setBounds(70, 18, 178, 21);
		panel_3.add(insertid);
		insertid.setColumns(10);
		
		insertCompanyName = new JTextField();
		insertCompanyName.setColumns(10);
		insertCompanyName.setBounds(347, 18, 178, 21);
		panel_3.add(insertCompanyName);
		
		JButton btnNewButton_2 = new JButton("조회");
		btnNewButton_2.setBounds(537, 17, 91, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("전체조회");
		btnNewButton_3.setBounds(770, 33, 91, 23);
		contentPane.add(btnNewButton_3);
		
		btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String company_name = tfcompanyName.getText();
				String category = tfcategory.getText();
				String income = tfincome.getText();
				String address = tfaddress.getText();
				
				ClientDTO dto = new ClientDTO();
				dto.setCompany_name(company_name);
				dto.setCategory(category);
				dto.setIncome(Integer.parseInt(income));
				dto.setAddress(address);
				
				ClientService service = new ClientServiceImpl();
				service.setDao(new ClientDAO());
				
				int n = service.insert(dto);
				System.out.println(n+"개가 저장됨");
				
				
			}
		});
		
		
		
		
	}
}
