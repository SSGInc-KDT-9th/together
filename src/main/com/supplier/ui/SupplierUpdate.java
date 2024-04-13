package main.com.supplier.ui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;
import main.com.supplier.repository.SupplierService;
import main.com.supplier.repository.SupplierServiceImpl;
import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;
import main.com.supplier.repository.SupplierService;
import main.com.supplier.repository.SupplierServiceImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField company_name;
	private JTextField company_category;
	private JTextField income;
	private JTextField address;
	private JButton resetBtn;
	private JButton updateBtn;
	private JButton cancelBtn;
	
	public SupplierUpdate(Supplier sup) {
		setTitle("수정");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		company_name = new JTextField();
		company_name.setBounds(100, 27, 150, 21);
		contentPane.add(company_name);
		company_name.setColumns(10);
		company_name.setText(sup.getCompany_name());
		
		company_category = new JTextField();
		company_category.setBounds(100, 77, 150, 21);
		contentPane.add(company_category);
		company_category.setColumns(10);
		company_category.setText(sup.getCompany_category());
		
		income = new JTextField();
		income.setBounds(100, 127, 150, 21);
		contentPane.add(income);
		income.setColumns(10);
		income.setText(String.valueOf(sup.getIncome()));

		address = new JTextField();
		address.setBounds(100, 177, 150, 21);
		contentPane.add(address);
		address.setColumns(10);
		address.setText(sup.getAddress());
		
		JLabel lblNewLabel = new JLabel("기업명");
		lblNewLabel.setBounds(30, 30, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("업종");
		lblNewLabel_1.setBounds(30, 80, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("거래액");
		lblNewLabel_2.setBounds(30, 130, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(30, 180, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		resetBtn = new JButton("초기화");
		resetBtn.setBounds(12, 247, 80, 23);
		contentPane.add(resetBtn);
		
		updateBtn = new JButton("수정하기");
		updateBtn.setBounds(100, 247, 80, 23);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(187, 247, 80, 23);
		contentPane.add(cancelBtn);
		
//		텍스트 지우기
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				company_name.setText(sup.getCompany_name());
				company_category.setText(sup.getCompany_category());
				income.setText(String.valueOf(sup.getIncome()));
				address.setText(sup.getAddress());
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SupplierService service = new SupplierServiceImpl();
				service.setSup(new SupplierDAO());
				
				sup.setCompany_name(company_name.getText());
				sup.setCompany_category(company_category.getText());
				sup.setIncome(Integer.parseInt(income.getText()));
				sup.setAddress(address.getText());
				
				service.update(sup);
							
				dispose();
				
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}

}
