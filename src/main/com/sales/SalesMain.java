package main.com.sales;

import main.com.client.dto.ClientDTO;
import main.com.client.service.ClientService;
import main.com.config.AppConfig;
import main.com.product.service.ProductService;
import main.com.sales.request.SalesSearch;
import main.com.sales.response.ClientSalesInfo;
import main.com.sales.response.ProductSalesInfo;
import main.com.sales.service.SalesService;
import main.com.util.TryParse;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;


public class SalesMain extends JFrame {
	private SalesService salesService;
	private ClientService clientService;
	private ProductService productService;
	private JPanel mainPanel;
	private JLabel ClientSearchLabel;
	private JTextField clientIdText;
	private JTextField clientNameText;
	private JLabel productNameLabel;
	private JLabel clientIdLabel;
	private JButton resetClientButton;
	private JTextField productIdText;
	private JTextField productNameText;
	private JButton resetProductButton;
	private JButton resetButton;
	private JButton clientSearch;
	private JLabel productSearchLabel;
	private JLabel productIdLabel;
	private JLabel nameSearchLabel;
	private JButton productSearch;

	private JLabel searchNameLabel;
	private JLabel startDateLabel;
	private JFormattedTextField startProductText;
	private JLabel endDateLabel;
	private JFormattedTextField endProductText;
	private JTable table;
	private DefaultTableModel model;
	private String[] productCol = {"","상품 ID","상품 이름", "상품 카테고리", "총 판매액(원)"};
	private String[] clientCol = {"","고객 기업 ID","고객 기업 이름", "기업 카테고리", "총 구매액(원)"};
	private JLabel endDateClientLabel;
	private JLabel startDateClientLabel;
	private JFormattedTextField startClientText;
	private JFormattedTextField endClientText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMain app = new SalesMain();
					app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent() {
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		//검색 기능

		productSearchLabel = new JLabel("상품 검색");
		productSearchLabel.setFont(new Font("굴림", Font.BOLD, 15));
		productSearchLabel.setBounds(925, 105, 150, 25);

		productIdLabel = new JLabel("상품 ID");
		productIdLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productIdLabel.setBounds(925, 139, 70, 25);

		productIdText = new JTextField();
		productIdText.setColumns(10);
		productIdText.setBounds(1007, 139, 200, 25);

		nameSearchLabel = new JLabel("상품 이름");
		nameSearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		nameSearchLabel.setBounds(925, 174, 70, 25);


		productNameText = new JTextField();
		productNameText.setColumns(10);
		productNameText.setBounds(1007, 174, 200, 25);

		startDateLabel = new JLabel("시작일");
		startDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		startDateLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		startDateLabel.setBounds(925, 211, 70, 25);

		endDateLabel = new JLabel("마감일");
		endDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		endDateLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		endDateLabel.setBounds(925, 246, 70, 25);

		try{
			MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
			startProductText = new JFormattedTextField(dateFormatter);
			startProductText.setBounds(1007, 211, 200, 25);
			endProductText = new JFormattedTextField(dateFormatter);
			endProductText.setBounds(1007, 246, 200, 25);
		}
		catch (ParseException e){
			e.printStackTrace();
		}

		searchNameLabel = new JLabel("매출 조회");
		searchNameLabel.setFont(new Font("굴림", Font.BOLD, 15));
		searchNameLabel.setBounds(12, 66, 150, 25);

		productSearch = new JButton("검색");
		productSearch.setBounds(925, 285, 130, 30);
		resetProductButton = new JButton("초기화");
		resetProductButton.setBounds(1077, 285, 130, 30);
		//상세 보기 라벨
		ClientSearchLabel = new JLabel("고객 기업 검색");
		ClientSearchLabel.setFont(new Font("굴림", Font.BOLD, 15));
		ClientSearchLabel.setBounds(925, 392, 150, 25);

		clientIdLabel = new JLabel("고객 ID");
		clientIdLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		clientIdLabel.setBounds(929, 421, 70, 25);

		productNameLabel = new JLabel("고객 이름");
		productNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productNameLabel.setBounds(929, 456, 70, 25);

		//상세보기 Text
		clientIdText = new JTextField();
		clientIdText.setBounds(1011, 421, 200, 25);
		clientIdText.setColumns(10);

		clientNameText = new JTextField();
		clientNameText.setColumns(10);
		clientNameText.setBounds(1011, 456, 200, 25);

		startDateClientLabel = new JLabel("시작일");
		startDateClientLabel.setHorizontalAlignment(SwingConstants.LEFT);
		startDateClientLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		startDateClientLabel.setBounds(929, 491, 70, 25);

		endDateClientLabel = new JLabel("마감일");
		endDateClientLabel.setHorizontalAlignment(SwingConstants.LEFT);
		endDateClientLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		endDateClientLabel.setBounds(929, 526, 70, 25);

		try{
			MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
			startClientText = new JFormattedTextField(dateFormatter);
			startClientText.setBounds(1011, 491, 200, 25);
			endClientText = new JFormattedTextField(dateFormatter);
			endClientText.setBounds(1011, 526, 200, 25);
		}catch(ParseException e){
			e.printStackTrace();
		}
		//상품 상세 수정 버튼
		clientSearch = new JButton("검색");
		clientSearch.setBounds(925, 561, 130, 30);


		resetClientButton = new JButton("초기화");
		resetClientButton.setBounds(1077, 561, 130, 30);
		resetButton = new JButton("초기화");
		resetButton.setBounds(783, 63, 130, 30);
	}

	private void setDisplay(){
		mainPanel.setLayout(null);

		//조회 관련 컴포넌트 패널 추가
		mainPanel.add(clientIdText);
		mainPanel.add(clientNameText);
		mainPanel.add(clientSearch);
		mainPanel.add(clientIdLabel);
		mainPanel.add(productNameLabel);
		mainPanel.add(resetClientButton);
		mainPanel.add(ClientSearchLabel);

		//상품 검색
		mainPanel.add(productSearchLabel);
		mainPanel.add(productIdLabel);
		mainPanel.add(productIdText);
		mainPanel.add(nameSearchLabel);
		mainPanel.add(productNameText);
		mainPanel.add(productSearch);
		mainPanel.add(resetProductButton);
		mainPanel.add(resetButton);
		mainPanel.add(startClientText);

		//테이블 설정
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10); // Set width for checkbox column
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Enable multiple selections
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 105, 900, 486); // Adjust bounds as needed
		mainPanel.add(scrollPane);
		

		mainPanel.add(searchNameLabel);
		mainPanel.add(startDateLabel);
		mainPanel.add(startProductText);
		mainPanel.add(endDateLabel);
		mainPanel.add(endProductText);
		mainPanel.add(endDateClientLabel);
		mainPanel.add(startDateClientLabel);
		mainPanel.add(endClientText);
	}

	void setInitComponentData(){
		SalesSearch salesSearch = SalesSearch.builder().build();
		List<ProductSalesInfo> productSales = salesService.getProductSales(null,"", null, null);
		Object[][] data = productSales.stream()
				.map(info -> new Object[]{
						false,
						info.getProductId(),
						info.getProductName(),
						info.getProductCategory(),
						info.getTotalPrice()
				})
				.toArray(Object[][]::new);
		model = new DefaultTableModel(data, productCol) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
			}
		};
	}

	void setListenerEvent(){
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[][] data={};
				model = new DefaultTableModel(data, productCol) {
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
					}
				};
				table.setModel(model);
			}
		});

		productSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = productIdText.getText();
				Long productId = null;
				try{
					productId = TryParse.tryParseLong(id,productId);
				}catch (IllegalArgumentException exception){
					exception.printStackTrace();
				}

				String productName = productNameText.getText();
				if(!productName.isEmpty() && productId==null){
					productId = productService.get(productName).getId();
				}

				String start = startProductText.getText();
				String end = endProductText.getText();

				if(start.equals("    -  -  ")){
					start = LocalDate.of(1, 1, 1).toString();
				}
				if(end.equals("    -  -  ")){
					end= LocalDate.of(9999,12,31).toString();
				}

				try{
					LocalDate startDate = parseDateTime(start);
					LocalDate endDate = parseDateTime(end);
				} catch (DateTimeParseException ex){
					ex.printStackTrace();
					int check = JOptionPane.showConfirmDialog(null, "올바른 날짜를 입력하세요", "날짜 확인", JOptionPane.PLAIN_MESSAGE);
					return;
				}

				List<ProductSalesInfo> productSales = salesService.getProductSales(productId,productName, start, end);
				Object[][] data = productSales.stream()
						.map(info -> new Object[]{
								false,
								info.getProductId(),
								info.getProductName(),
								info.getProductCategory(),
								info.getTotalPrice()
						})
						.toArray(Object[][]::new);
				model = new DefaultTableModel(data, productCol) {
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
					}
				};
				table.setModel(model);
			}
		});

		clientSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = clientIdText.getText();
				Long clientId = null;
				try{
					clientId = TryParse.tryParseLong(id,clientId);
				}catch (IllegalArgumentException exception){
					exception.printStackTrace();
                }

				String clientName =clientNameText.getText();
				if(!clientName.isEmpty() && clientId==null){
					ClientDTO clientDTO = clientService.findByCompanyName(clientName).get(0);
					clientId = (long)clientDTO.getId();
				}

				String start = startClientText.getText();
				String end = endClientText.getText();

				if(start.equals("    -  -  ")){
					start = LocalDate.of(1, 1, 1).toString();
				}
				if(end.equals("    -  -  ")){
					end= LocalDate.of(9999,12,31).toString();
				}

				try{
					LocalDate startDate = parseDateTime(start);
					LocalDate endDate = parseDateTime(end);
				} catch (DateTimeParseException ex){
					ex.printStackTrace();
					int check = JOptionPane.showConfirmDialog(null, "올바른 날짜를 입력하세요", "날짜 확인", JOptionPane.PLAIN_MESSAGE);
					return;
				}
				List<ClientSalesInfo> productSales = new ArrayList<>();
				productSales = salesService.getClientSales(clientId,clientName, start, end);
				Object[][] data = productSales.stream()
						.map(info -> new Object[]{
								false,
								info.getClientId(),
								info.getClientName(),
								info.getClientCategory(),
								info.getTotalPrice()
						})
						.toArray(Object[][]::new);
				model = new DefaultTableModel(data, clientCol) {
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
					}
				};
				table.setModel(model);
			}
		});

		resetClientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientIdText.setText("");
				clientNameText.setText("");
				startClientText.setValue(null);
				endClientText.setValue(null);
			}
		});

		resetProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productIdText.setText("");
				productNameText.setText("");
				startProductText.setValue(null);
				endProductText.setValue(null);
			}
		});
	}


	private LocalDate parseDateTime(String input) throws DateTimeParseException {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendPattern("yyyy-MM-dd")
				.toFormatter()
				.withResolverStyle(ResolverStyle.LENIENT);
		return LocalDate.parse(input, formatter);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public SalesMain() {
		AppConfig appConfig = new AppConfig();
		salesService = appConfig.salesService();
		clientService = appConfig.clientService();
		productService = appConfig.productService();
		setInitComponentData();
		initComponent();
		setDisplay();
		setListenerEvent();
	}
}