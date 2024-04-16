package main.com.store.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.com.config.AppConfig;
import main.com.config.Session;
import main.com.product.domain.Product;
import main.com.product.service.ProductService;
import main.com.stock.domain.StockEdit;
import main.com.stock.service.StockService;
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
import java.text.ParseException;
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
	private ProductService productService;
	private StockService stockService;
	private JTextField textField_id;
	private JTextField textField_productId;
	private JTextField textField_storeDate;
	private JTextField textField_storeCnt;
	private JTextField textField_storePrice;
	private JTextField textField_deleteId;
	private JComboBox textField_storeStatus;
	private JTextField textField_updateId;
	private JTextField textField_updateProductId;
	private JTextField textField_updateStoreDate;
	private JTextField textField_updateStoreCnt;
	private JComboBox textField_updateStoreStatus;
	private JTextField textField_updateStorePrice;
	private JTextField textField_productName;
	
	private JButton btnFind;
	private JButton btnFindAll;
	private JButton btnFindReset;
	private JButton btnInsert;
	private JButton btnReset;
	private JButton btnUpdate;
	private JButton btnUpdateReset;
	private JButton btnDelete;
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

		AppConfig appConfig =new AppConfig();
		productService = appConfig.productService();
		stockService = appConfig.stockService();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 117, 833, 556);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String [] header = {"입고번호","상품ID","사용자ID","입고일자","입고수량","입고상태","입고가격(개당단가)"};
		String [][] obj = {};
		
		DefaultTableModel dm = new DefaultTableModel(obj, header);
		table.setModel(dm);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 10, 833, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("입고번호");
		lblNewLabel.setBounds(12, 35, 83, 24);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_id.setBounds(100, 31, 116, 33);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("상품명");
		lblNewLabel_1.setBounds(231, 35, 63, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));

		
		btnFind = new JButton("조회");
		btnFind.setBounds(470, 31, 101, 33);
		panel.add(btnFind);
		btnFind.setFont(new Font("굴림", Font.PLAIN, 20));
		
		btnFindAll = new JButton("전체조회");
		btnFindAll.setFont(new Font("굴림", Font.PLAIN, 20));
		btnFindAll.setBounds(583, 31, 125, 33);
		panel.add(btnFindAll);
		
		btnFindReset = new JButton("초기화");
		btnFindReset.setFont(new Font("굴림", Font.PLAIN, 20));
		btnFindReset.setBounds(720, 31, 101, 33);
		panel.add(btnFindReset);
		
		textField_productName = new JTextField();
		textField_productName.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_productName.setColumns(10);
		textField_productName.setBounds(296, 31, 162, 33);
		panel.add(textField_productName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(893, 10, 361, 249);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("상품ID");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 10, 71, 30);
		panel_1.add(lblNewLabel_2);
		
		btnInsert = new JButton("등록");
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInsert.setBounds(69, 210, 98, 30);
		panel_1.add(btnInsert);
		
		textField_productId = new JTextField();
		textField_productId.setBounds(149, 10, 141, 30);
		panel_1.add(textField_productId);
		textField_productId.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("입고일자");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(41, 50, 85, 30);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("입고수량");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(41, 90, 85, 30);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("입고상태");
		lblNewLabel_2_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_1.setBounds(41, 130, 85, 30);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("입고금액");
		lblNewLabel_2_3_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2.setBounds(41, 170, 85, 30);
		panel_1.add(lblNewLabel_2_3_2);
		
		textField_storeDate = new JTextField();
		textField_storeDate.setColumns(10);
		textField_storeDate.setBounds(149, 50, 141, 30);
		panel_1.add(textField_storeDate);
		
		textField_storeCnt = new JTextField();
		textField_storeCnt.setColumns(10);
		textField_storeCnt.setBounds(149, 90, 141, 30);
		panel_1.add(textField_storeCnt);
		
		textField_storePrice = new JTextField();
		textField_storePrice.setColumns(10);
		textField_storePrice.setBounds(149, 170, 141, 30);
		panel_1.add(textField_storePrice);
		
		textField_storeStatus = new JComboBox(StoreStatus);
		textField_storeStatus.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_storeStatus.setBounds(149, 130, 141, 30);
		panel_1.add(textField_storeStatus);
		
		btnReset = new JButton("초기화");
		btnReset.setBounds(200, 210, 101, 30);
		panel_1.add(btnReset);
		btnReset.setFont(new Font("굴림", Font.PLAIN, 20));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(893, 559, 361, 114);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("입고번호");
		lblNewLabel_2_3_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2_1.setBounds(69, 10, 85, 30);
		panel_2.add(lblNewLabel_2_3_2_1);
		
		btnDelete = new JButton("삭제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDelete.setBounds(130, 50, 98, 30);
		panel_2.add(btnDelete);
		
		textField_deleteId = new JTextField();
		textField_deleteId.setColumns(10);
		textField_deleteId.setBounds(176, 10, 141, 30);
		panel_2.add(textField_deleteId);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(893, 264, 361, 290);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("입고번호");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(41, 10, 95, 30);
		panel_3.add(lblNewLabel_2_1);
		
		textField_updateId = new JTextField();
		textField_updateId.setColumns(10);
		textField_updateId.setBounds(149, 10, 141, 30);
		panel_3.add(textField_updateId);
		
		JLabel lblNewLabel_2_4 = new JLabel("상품ID");
		lblNewLabel_2_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(52, 50, 71, 30);
		panel_3.add(lblNewLabel_2_4);
		
		textField_updateProductId = new JTextField();
		textField_updateProductId.setColumns(10);
		textField_updateProductId.setBounds(149, 50, 141, 30);
		panel_3.add(textField_updateProductId);
		
		JLabel lblNewLabel_2_5 = new JLabel("입고일자");
		lblNewLabel_2_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_5.setBounds(41, 90, 95, 30);
		panel_3.add(lblNewLabel_2_5);
		
		textField_updateStoreDate = new JTextField();
		textField_updateStoreDate.setColumns(10);
		textField_updateStoreDate.setBounds(149, 90, 141, 30);
		panel_3.add(textField_updateStoreDate);
		
		JLabel lblNewLabel_2_6 = new JLabel("입고수량");
		lblNewLabel_2_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_6.setBounds(41, 130, 95, 30);
		panel_3.add(lblNewLabel_2_6);
		
		textField_updateStoreCnt = new JTextField();
		textField_updateStoreCnt.setColumns(10);
		textField_updateStoreCnt.setBounds(149, 130, 141, 30);
		panel_3.add(textField_updateStoreCnt);		

		JLabel lblNewLabel_2_7 = new JLabel("입고상태");
		lblNewLabel_2_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_7.setBounds(41, 170, 95, 30);
		panel_3.add(lblNewLabel_2_7);
		
		textField_updateStoreStatus = new JComboBox(StoreStatus);
		textField_updateStoreStatus.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_updateStoreStatus.setBounds(149, 170, 141, 30);
		panel_3.add(textField_updateStoreStatus);		
		
		JLabel lblNewLabel_2_8 = new JLabel("입고금액");
		lblNewLabel_2_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_8.setBounds(41, 210, 95, 30);
		panel_3.add(lblNewLabel_2_8);
		
		textField_updateStorePrice = new JTextField();
		textField_updateStorePrice.setColumns(10);
		textField_updateStorePrice.setBounds(149, 210, 141, 30);
		panel_3.add(textField_updateStorePrice);			
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(69, 250, 98, 30);
		panel_3.add(btnUpdate);
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 20));
		
		btnUpdateReset = new JButton("초기화");
		btnUpdateReset.setFont(new Font("굴림", Font.PLAIN, 20));
		btnUpdateReset.setBounds(200, 250, 101, 30);
		panel_3.add(btnUpdateReset);
		
		//등록 초기화 버튼 이벤트 처리
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_productId.setText("");
				textField_storeDate.setText("");
				textField_storeCnt.setText("");
				textField_storeStatus.setSelectedItem(StoreStatus[0]);
				textField_storePrice.setText("");
				
			}
		});//end

		//입고 등록 버튼 이벤트 처리
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String product_id = textField_productId.getText();
				String store_date = textField_storeDate.getText();
				String store_count = textField_storeCnt.getText();
				String status = textField_storeStatus.getSelectedItem().toString();
				String store_price = textField_storePrice.getText();
				
				StoreDTO dto = new StoreDTO();
				Long member_id = Session.getMember().getId();
				dto.setProduct_id(Long.parseLong(product_id));
				dto.setStore_date(store_date);
				dto.setStore_count(Integer.parseInt(store_count));
				dto.setStatus(status);
				dto.setStore_price(Integer.parseInt(store_price));
				
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());
				
				int n = service.insert(dto);

				List<StoreDTO> list = service.findAll();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);

				for (StoreDTO store : list) {
					Object[] rowData = {
							store.getId(),
							store.getProduct_id(),
							store.getMember_id(),
							store.getStore_date(),
							store.getStore_count(),
							store.getStatus(),
							store.getStore_price()
					};
					model.addRow(rowData);
				}
			}
		});//end
		
		//입고 수정 버튼 이벤트 처리
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());

				String updateId = textField_updateId.getText();
				String updateProductId = textField_updateProductId.getText();
				String updateStoreDate = textField_updateStoreDate.getText();
				String updateStoreCnt = textField_updateStoreCnt.getText();
				String updateStoreStatus = textField_updateStoreStatus.getSelectedItem().toString();
				String updateStorePrice = textField_updateStorePrice.getText();

				StoreDTO store = service.findById(Long.parseLong(updateId));
				String storeStatus = store.getStatus();

				if(storeStatus.equals("입고완료")){
					JOptionPane.showMessageDialog(null, "수정할 수 없습니다.");
					return;
				}

				StoreDTO dto = new StoreDTO();
				dto.setId(Long.parseLong(updateId));
				dto.setProduct_id(Long.parseLong(updateProductId));
				dto.setStore_date(updateStoreDate);
				dto.setStore_count(Integer.parseInt(updateStoreCnt));
				dto.setStatus(updateStoreStatus);
				dto.setStore_price(Integer.parseInt(updateStorePrice));
				service.update(dto);

				StoreDTO updatedStore = service.findById(Long.parseLong(updateId));
				if(updatedStore.getStatus().equals("입고완료")){
					long productId = updatedStore.getProduct_id();
					int add = Integer.parseInt(updateStoreCnt);
					Integer currentInventory = stockService.getByProduct(productId).getInventory();
					StockEdit stockEdit = StockEdit.builder()
							.inventory(currentInventory+add)
							.storePrice(Integer.parseInt(updateStorePrice)).build();
					stockService.editStore(productId,stockEdit);
				}

				JOptionPane.showConfirmDialog(null, "입고 최종 완료", "입고 완료", JOptionPane.PLAIN_MESSAGE);
			}
		});//end
		
		//수정 초기화 버튼 이벤트 처리
		btnUpdateReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_updateId.setText("");
				textField_updateProductId.setText("");
				textField_updateStoreDate.setText("");
				textField_updateStoreCnt.setText("");
				textField_updateStoreStatus.setSelectedItem(StoreStatus[0]);
				textField_updateStorePrice.setText("");
				
			}
		});//end
		
		//입고 전체조회 버튼 이벤트 처리
		btnFindAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());
				
				List<StoreDTO> list = service.findAll();
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				
				for (StoreDTO store : list) {
					Object[] rowData = {
							store.getId(),
							store.getProduct_id(),
							store.getMember_id(),
							store.getStore_date(),
							store.getStore_count(),
							store.getStatus(),
							store.getStore_price()
					};
					model.addRow(rowData);
				}
			}
		});//end
		
		//상품명 조회 버튼 이벤트 처리
		btnFind.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_id.getText();
				String productName = textField_productName.getText();
				Product product = productService.get(productName);

				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());

				StoreDTO storeDTO = new StoreDTO();
				if(product!=null){
					storeDTO.setProduct_id(product.getId());
				}
				if(!id.isEmpty()){
					storeDTO.setId(Long.parseLong(id));
				}
				List<StoreDTO> list = service.findStore(storeDTO);

				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);

				for (StoreDTO store : list) {
					Object[] rowData = {
							store.getId(),
							store.getProduct_id(),
							store.getMember_id(),
							store.getStore_date(),
							store.getStore_count(),
							store.getStatus(),
							store.getStore_price()
					};
					model.addRow(rowData);
				}
			}
		});//end
		
		//조회 테이블 초기화 버튼 이벤트 처리
		btnFindReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0);
		        
		        textField_id.setText("");
		        textField_productName.setText("");
		        
			}
		});//end
		
		//입고번호를 통한 입고정보 삭제 버튼 이벤트 처리
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_deleteId.getText();
				
				StoreService service = new StoreServiceImpl();
				service.setDao(new StoreDAO());				
				int n = service.delete(Integer.parseInt(id));
				
				if(n>0) {
				 Object[] options = { "OK", "CANCEL" };
				 JOptionPane.showOptionDialog(null, "해당 입고정보 삭제하시겠습니까?", "Warning",
				             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				             null, options, options[0]);
				 DefaultTableModel model = (DefaultTableModel)table.getModel();
				 for(int i = 0; i< model.getRowCount(); i++) {
					 if(model.getValueAt(i, 0).equals(id)) {
						 model.removeRow(i);
						 break;
					 }
				 }
				}
			}
		});//end	
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if(selectedRow != -1) {
					textField_updateId.setText(table.getValueAt(selectedRow, 0).toString());
					textField_updateProductId.setText(table.getValueAt(selectedRow, 1).toString());
					textField_updateStoreDate.setText(table.getValueAt(selectedRow, 3).toString());
					textField_updateStoreCnt.setText(table.getValueAt(selectedRow, 4).toString());
					textField_updateStoreStatus.setSelectedItem(table.getValueAt(selectedRow, 5));
					textField_updateStorePrice.setText(table.getValueAt(selectedRow, 6).toString());
					}
				}
			}
		});
	}
	public JPanel getMainPane(){
		return contentPane;
	}
}
