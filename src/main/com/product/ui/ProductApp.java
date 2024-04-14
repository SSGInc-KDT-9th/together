package main.com.product.ui;

import main.com.config.AppConfig;
import main.com.product.domain.Product;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;
import main.com.product.service.CategoryService;
import main.com.product.service.ProductService;
import main.com.product.service.ProductServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ProductApp extends JFrame {
	private ProductService productService;
	private CategoryService categoryService;
	private JPanel mainPanel;
	private JLabel productInfoLabel;
	private JTextField productIdText;
	private JTextField productNameText;
	private JTextField supplierNameText;
	private JLabel productNameLabel;
	private JLabel mainCategoryLabel;
	private JComboBox mainCategoryCombo;
	private JLabel supplierNameLabel;
	private JLabel storePriceLabel;
	private JLabel productIdLabel;
	private JLabel subCategoryLabel;
	private JTextField storePriceText;
	private JTextField sellingPriceText;
	private JLabel sellingPriceLabel;
	private JLabel inventoryLabel;
	private JTextField inventoryText;
	private JButton resetButton;
	private JTextField idSearchText;
	private JTextField nameSearchText;
	private JTextField supplierSearchText;
	private JButton searchResetButton;
	private JButton productInfoResetButton;
	private JButton saveButton;
	private JLabel supplierSearchLabel;
	private JLabel categorySearchLabel;
	private JComboBox categorySerachCombo;
	private JComboBox subCategoryCombo;
	private JLabel productSearchLabel;
	private JLabel idSearchLabel;
	private JLabel nameSearchLabel;
	private JButton searchButton;
	private JButton deleteButton;
	private JTable table;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductApp app = new ProductApp();
					app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initComponent(){
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);


		//검색 기능
		productSearchLabel = new JLabel("- 상품 검색");
		productSearchLabel.setFont(new Font("굴림", Font.BOLD, 15));
		productSearchLabel.setBounds(921, 70, 150, 25);

		idSearchLabel = new JLabel("상품 ID");
		idSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		idSearchLabel.setBounds(925, 105, 70, 25);

		idSearchText = new JTextField();
		idSearchText.setColumns(10);
		idSearchText.setBounds(1007, 105, 200, 25);

		nameSearchLabel = new JLabel("상품 이름");
		nameSearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		nameSearchLabel.setBounds(925, 140, 70, 25);

		nameSearchText = new JTextField();
		nameSearchText.setColumns(10);
		nameSearchText.setBounds(1007, 140, 200, 25);

		supplierSearchLabel = new JLabel("생산 기업명");
		supplierSearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		supplierSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		supplierSearchLabel.setBounds(925, 175, 80, 25);

		supplierSearchText = new JTextField();
		supplierSearchText.setColumns(10);
		supplierSearchText.setBounds(1007, 175, 200, 25);

		categorySearchLabel = new JLabel("상품 분류");
		categorySearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		categorySearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		categorySearchLabel.setBounds(925, 210, 70, 25);

		categorySerachCombo = new JComboBox();
		categorySerachCombo.setBounds(1007, 211, 200, 23);

		searchButton = new JButton("검색");
		searchButton.setBounds(925, 245, 130, 30);
		searchResetButton = new JButton("초기화");
		searchResetButton.setBounds(1077, 245, 130, 30);
		//상세 보기 라벨
		productInfoLabel = new JLabel("- 상품 상세 정보");
		productInfoLabel.setFont(new Font("굴림", Font.BOLD, 15));
		productInfoLabel.setBounds(925, 296, 150, 25);

		productIdLabel = new JLabel("상품 ID");
		productIdLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productIdLabel.setBounds(925, 331, 70, 25);

		productNameLabel = new JLabel("상품 이름");
		productNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productNameLabel.setBounds(925, 366, 70, 25);

		supplierNameLabel = new JLabel("생산 기업명");
		supplierNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		supplierNameLabel.setBounds(925, 471, 80, 25);

		mainCategoryLabel = new JLabel("대분류");
		mainCategoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		mainCategoryLabel.setBounds(925, 401, 70, 25);

		subCategoryLabel = new JLabel("소분류");
		subCategoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		subCategoryLabel.setBounds(925, 436, 70, 25);

		storePriceLabel = new JLabel("입고 금액");
		storePriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		storePriceLabel.setBounds(925, 508, 80, 25);

		sellingPriceLabel = new JLabel("출고 금액");
		sellingPriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		sellingPriceLabel.setBounds(925, 543, 80, 25);

		inventoryLabel = new JLabel("상품 재고");
		inventoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		inventoryLabel.setBounds(925, 578, 80, 25);

		//상세보기 Text
		productIdText = new JTextField();
		productIdText.setBounds(1007, 331, 200, 25);
		productIdText.setColumns(10);

		productNameText = new JTextField();
		productNameText.setColumns(10);
		productNameText.setBounds(1007, 366, 200, 25);

		supplierNameText = new JTextField();
		supplierNameText.setColumns(10);
		supplierNameText.setBounds(1007, 471, 200, 25);

		storePriceText = new JTextField();
		storePriceText.setEnabled(false);
		storePriceText.setColumns(10);
		storePriceText.setBounds(1007, 508, 200, 25);

		sellingPriceText = new JTextField();
		sellingPriceText.setEnabled(false);
		sellingPriceText.setColumns(10);
		sellingPriceText.setBounds(1007, 543, 200, 25);

		inventoryText = new JTextField();
		inventoryText.setEnabled(false);
		inventoryText.setColumns(10);
		inventoryText.setBounds(1007, 578, 200, 25);

		mainCategoryCombo = new JComboBox();
		mainCategoryCombo.setBounds(1007, 403, 200, 23);

		subCategoryCombo = new JComboBox();
		subCategoryCombo.setBounds(1007, 438, 200, 23);
		//상품 상세 수정 버튼
		saveButton = new JButton("저장");
		saveButton.setBounds(925, 629, 130, 30);

		resetButton = new JButton("초기화");
		resetButton.setBounds(1077, 629, 130, 30);

		//상품 삭제 버튼
		deleteButton = new JButton("삭제");
		deleteButton.setBounds(743, 107, 130, 30);
		productInfoResetButton = new JButton("초기화");
		productInfoResetButton.setBounds(597, 107, 130, 30);
	}

	private void setDisplay(){
		mainPanel.setLayout(null);

		//조회 관련 컴포넌트 패널 추가
		mainPanel.add(productIdText);
		mainPanel.add(productNameText);
		mainPanel.add(supplierNameText);
		mainPanel.add(saveButton);
		mainPanel.add(productIdLabel);
		mainPanel.add(productNameLabel);
		mainPanel.add(mainCategoryLabel);
		mainPanel.add(supplierNameLabel);
		mainPanel.add(storePriceLabel);
		mainPanel.add(storePriceText);
		mainPanel.add(sellingPriceText);
		mainPanel.add(sellingPriceLabel);
		mainPanel.add(inventoryLabel);
		mainPanel.add(inventoryText);
		mainPanel.add(mainCategoryCombo);
		mainPanel.add(resetButton);
		mainPanel.add(productInfoLabel);
		
		//상품 검색
		mainPanel.add(productSearchLabel);
		mainPanel.add(idSearchLabel);
		mainPanel.add(idSearchText);
		mainPanel.add(nameSearchLabel);
		mainPanel.add(nameSearchText);
		mainPanel.add(supplierSearchText);
		mainPanel.add(supplierSearchLabel);
		mainPanel.add(categorySearchLabel);
		mainPanel.add(searchButton);
		mainPanel.add(deleteButton);
		mainPanel.add(categorySerachCombo);
		mainPanel.add(subCategoryLabel);
		mainPanel.add(subCategoryCombo);
		mainPanel.add(searchResetButton);
		mainPanel.add(productInfoResetButton);



		//테이블 설정
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10); // Set width for checkbox column
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Enable multiple selections
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 160, 900, 500); // Adjust bounds as needed
		mainPanel.add(scrollPane);

	}

	void setProductTable(){
		String[] columnNames = {"","상품 ID", "상품 이름", "상품 카테고리 ID", "상품 카테고리", "공급 기업 ID","공급 기업 이름","입고 금액0","출고 금액","재고량"};
		ProductSearch search = ProductSearch.builder().build();
		List<ProductInfo> products = productService.getList(search);
		Object[][] data = products.stream()
				.map(product -> new Object[]{
						false,
						product.getId(),
						product.getProductName(),
						product.getCategoryId(),
						product.getCategoryName(),
						product.getSupplierId(),
						product.getSupplierName(),
						product.getStorePrice(),
						product.getSellingPrice(),
						product.getInventory()
				})
				.toArray(Object[][]::new);
		model = new DefaultTableModel(data, columnNames) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
			}
		};

	}

	void setListenerEvent(){
		productInfoResetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.getRowCount());
				for(int i=0; i<model.getRowCount(); i++){
					boolean check =(boolean) model.getValueAt(i, 0);
					if(check){
						System.out.println(model.getValueAt(i,1));
					}
				}
			}
		});
	}

	// Sample DTO class ProductInfo

	public ProductApp() {
		AppConfig appConfig = new AppConfig();
		productService = appConfig.productService();
		categoryService = appConfig.categoryService();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720); // Adjusted for HD resolution (16:9 aspect ratio)
		setProductTable();
		initComponent();
		setDisplay();
		setListenerEvent();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
