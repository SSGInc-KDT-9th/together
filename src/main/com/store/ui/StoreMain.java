package main.com.store.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.client.service.ClientService;
import main.com.client.service.ClientServiceImpl;
import main.com.store.dao.StoreDAO;
import main.com.store.dto.StoreDTO;
import main.com.store.service.StoreService;
import main.com.store.service.StoreServiceImpl;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class StoreMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JComboBox textField_status;
	private JTextField textField_productId;
	private JTextField textField_storeDate;
	private JTextField textField_storeCnt;
	private JTextField textField_storePrice;
	private JTextField textField_deleteId;
	private JComboBox textField_storeStatus;
	
	private JButton btnfindAll;
	private JButton btnreset;
	private JButton btninsert;
	private JButton btnupdate;
	private JButton btndelete;
	private JTable table;
	
	String[] StoreStatus = { "입고중", "입고완료"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreMain frame = new StoreMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StoreMain() {
		setTitle("입고관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 203, 833, 445);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String [] header = {"입고번호","상품ID","사용자ID","입고일자","입고수량","입고상태","입고가격(개당단가)"};
		String [][] obj = {{"001","xxx","xxx","2024-04-15","100","입고중","1000"},
						   {"002","yyy","xxx","2024-04-15","100","입고완료","1000"}};
		
		DefaultTableModel dm = new DefaultTableModel(obj, header);
		table.setModel(dm);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 84, 833, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("입고번호");
		lblNewLabel.setBounds(43, 35, 83, 24);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_id.setBounds(138, 31, 180, 33);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("입고상태");
		lblNewLabel_1.setBounds(359, 35, 91, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		textField_status = new JComboBox(StoreStatus);
		textField_status.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_status.setBounds(462, 31, 180, 33);
		panel.add(textField_status);

		
		btnfindAll = new JButton("조회");
		btnfindAll.setBounds(667, 31, 101, 33);
		panel.add(btnfindAll);
		btnfindAll.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(893, 85, 361, 357);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("상품ID");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(41, 26, 71, 30);
		panel_1.add(lblNewLabel_2);
		
		btnupdate = new JButton("수정");
		btnupdate.setFont(new Font("굴림", Font.PLAIN, 20));
		btnupdate.setBounds(132, 303, 98, 30);
		panel_1.add(btnupdate);
		
		btninsert = new JButton("등록");
		btninsert.setFont(new Font("굴림", Font.PLAIN, 20));
		btninsert.setBounds(22, 303, 98, 30);
		panel_1.add(btninsert);
		
		textField_productId = new JTextField();
		textField_productId.setBounds(149, 29, 141, 30);
		panel_1.add(textField_productId);
		textField_productId.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("입고일자");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(41, 80, 85, 30);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("입고수량");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(41, 135, 85, 30);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("입고상태");
		lblNewLabel_2_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_1.setBounds(41, 184, 85, 30);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("입고금액");
		lblNewLabel_2_3_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2.setBounds(41, 237, 85, 30);
		panel_1.add(lblNewLabel_2_3_2);
		
		textField_storeDate = new JTextField();
		textField_storeDate.setColumns(10);
		textField_storeDate.setBounds(149, 83, 141, 30);
		panel_1.add(textField_storeDate);
		
		textField_storeCnt = new JTextField();
		textField_storeCnt.setColumns(10);
		textField_storeCnt.setBounds(149, 138, 141, 30);
		panel_1.add(textField_storeCnt);
		
		textField_storePrice = new JTextField();
		textField_storePrice.setColumns(10);
		textField_storePrice.setBounds(149, 237, 141, 30);
		panel_1.add(textField_storePrice);
		
		btnreset = new JButton("초기화");
		btnreset.setBounds(242, 302, 101, 33);
		panel_1.add(btnreset);
		btnreset.setFont(new Font("굴림", Font.PLAIN, 20));
		
		textField_storeStatus = new JComboBox(StoreStatus);
		textField_storeStatus.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_storeStatus.setBounds(149, 186, 141, 30);
		panel_1.add(textField_storeStatus);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(893, 452, 361, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("입고번호");
		lblNewLabel_2_3_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2_1.setBounds(39, 45, 85, 30);
		panel_2.add(lblNewLabel_2_3_2_1);
		
		btndelete = new JButton("삭제");
		btndelete.setFont(new Font("굴림", Font.PLAIN, 20));
		btndelete.setBounds(140, 107, 98, 30);
		panel_2.add(btndelete);
		
		textField_deleteId = new JTextField();
		textField_deleteId.setColumns(10);
		textField_deleteId.setBounds(156, 48, 141, 30);
		panel_2.add(textField_deleteId);
		
		//입고 조회 버튼 이벤트 처리
		btnfindAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});//end
		
		//입고 등록 버튼 이벤트 처리
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String product_id = textField_productId.getText();
				String store_date = textField_storeDate.getText();
				String store_count = textField_storeCnt.getText();
				String status = textField_storeStatus.getSelectedItem().toString();
				String store_price = textField_storePrice.getText();
				
				StoreDTO dto = new StoreDTO();
				dto.setProduct_id(Long.parseLong(product_id));
				dto.setStore_date(store_date);
				dto.setStore_count(Integer.parseInt(store_count));
				dto.setStatus(status);
				dto.setStore_price(Integer.parseInt(store_price));
				
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());
				
				int n = service.insert(dto);
				System.out.println(n+"개가 저장됨");
			}
		});//end

		//입고 수정 버튼 이벤트 처리
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String product_id = textField_productId.getText();
				String store_date = textField_storeDate.getText();
				String store_count = textField_storeCnt.getText();
				String status = textField_storeStatus.getSelectedItem().toString();
				String store_price = textField_storePrice.getText();
				
				StoreDTO dto = new StoreDTO();
				dto.setProduct_id(Long.parseLong(product_id));
				dto.setStore_date(store_date);
				dto.setStore_count(Integer.parseInt(store_count));
				dto.setStatus(status);
				dto.setStore_price(Integer.parseInt(store_price));
				
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());
				
				int n = service.insert(dto);
				System.out.println(n+"개가 수정됨");
			}
		});//end
		
		//초기화 버튼 이벤트 처리
		btnreset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_id.setText("");
				textField_productId.setText("");
				textField_storeDate.setText("");
				textField_storeCnt.setText("");
				textField_storeStatus.setSelectedItem(StoreStatus[0]);
				textField_storePrice.setText("");
				
			}
		});//end
		
		//입고번호를 통한 입고정보 삭제 버튼 이벤트 처리
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_deleteId.getText();
				
				StoreDTO dto = new StoreDTO();
				dto.setId(Integer.parseInt(id));
				
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());
				
				int n = service.delete(Integer.parseInt(id));
				System.out.println(n+"개가 삭제됨");
				
				 Object[] options = { "OK", "CANCEL" };
				 JOptionPane.showOptionDialog(null, "해당 입고정보 삭제하시겠습니까?", "Warning",
				             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				             null, options, options[0]);
			}
		});//end		
		


	}
}
