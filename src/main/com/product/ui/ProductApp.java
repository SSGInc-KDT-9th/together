package main.com.product.ui;

import main.com.config.AppConfig;
import main.com.product.domain.Category;
import main.com.product.domain.Product;
import main.com.product.domain.ProductEdit;
import main.com.product.request.ProductCreate;
import main.com.product.request.ProductSearch;
import main.com.product.response.ProductInfo;
import main.com.product.service.CategoryService;
import main.com.product.service.ProductService;
import main.com.supplier.domain.Supplier;
import main.com.supplier.service.SupplierService;
import main.com.util.TryParse;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ProductApp extends JFrame {
	private ProductService productService;
	private CategoryService categoryService;
	private SupplierService supplierService;
	private JPanel mainPanel;
	private JLabel productInfoLabel;
	private JTextField productIdText;
	private JTextField productNameText;
	private JComboBox supplierNameCombo;
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
	private JButton updateButton;
	private JTextField idSearchText;
	private JTextField nameSearchText;
	private JComboBox supplierSearchCombo;
	private JButton searchResetButton;
	private JButton productInfoResetButton;
	private JButton saveButton;
	private JLabel supplierSearchLabel;
	private JLabel mainCategorySearchLabel;
	private JLabel subCategorySearchLabel;
	private JComboBox mainCategorySearchCombo;
	private JComboBox subCategorySearchCombo;
	private JComboBox subCategoryCombo;
	private JLabel productSearchLabel;
	private JLabel idSearchLabel;
	private JLabel nameSearchLabel;
	private JButton searchButton;
	private JButton deleteButton;
	private JTable table;
	private DefaultTableModel model;
	private String[] columnNames = {"","상품 ID", "상품 이름", "상품 카테고리 ID", "상품 카테고리", "공급 기업 ID","공급 기업 이름","입고 금액","출고 금액","재고량"};

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

		String[] mainCategories = categoryService.getParents().stream()
				.map(Category::getCategoryName).toArray(String[]::new);

		List<String> subList  = categoryService.getChild().stream()
				.map(Category::getCategoryName).collect(Collectors.toList());
		subList.add(0, "");
		String[] subCategories = subList.toArray(new String[0]);

		List<String> suppliers = supplierService.supplierFindAll(new Supplier()).stream()
				.map(Supplier::getCompany_name).collect(Collectors.toList());
		suppliers.add(0,"");
		String[] supplierList = suppliers.toArray(new String[0]);
		//검색 기능
		productSearchLabel = new JLabel("- 상품 검색");
		productSearchLabel.setFont(new Font("굴림", Font.BOLD, 15));
		productSearchLabel.setBounds(921, 10, 150, 25);

		idSearchLabel = new JLabel("상품 ID");
		idSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		idSearchLabel.setBounds(925, 45, 70, 25);

		idSearchText = new JTextField();
		idSearchText.setColumns(10);
		idSearchText.setBounds(1007, 45, 200, 25);

		nameSearchLabel = new JLabel("상품 이름");
		nameSearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		nameSearchLabel.setBounds(925, 80, 70, 25);

		nameSearchText = new JTextField();
		nameSearchText.setColumns(10);
		nameSearchText.setBounds(1007, 80, 200, 25);

		supplierSearchLabel = new JLabel("생산 기업명");
		supplierSearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		supplierSearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		supplierSearchLabel.setBounds(925, 115, 80, 25);

		supplierSearchCombo = new JComboBox();
		supplierSearchCombo.setBounds(1007, 115, 200, 25);
		supplierSearchCombo.setModel(new DefaultComboBoxModel(supplierList));

		mainCategorySearchLabel = new JLabel("대분류");
		mainCategorySearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mainCategorySearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		mainCategorySearchLabel.setBounds(925, 150, 70, 25);

		mainCategorySearchCombo = new JComboBox();
		mainCategorySearchCombo.setBounds(1007, 151, 200, 23);

		subCategorySearchLabel = new JLabel("소분류");
		subCategorySearchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subCategorySearchLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		subCategorySearchLabel.setBounds(925, 185, 70, 25);

		subCategorySearchCombo = new JComboBox();
		subCategorySearchCombo.setBounds(1007, 186, 200, 23);

		mainCategorySearchCombo.setModel(new DefaultComboBoxModel(mainCategories));
		subCategorySearchCombo.setModel(new DefaultComboBoxModel(subCategories));

		searchButton = new JButton("검색");
		searchButton.setBounds(925, 226, 130, 30);
		searchResetButton = new JButton("초기화");
		searchResetButton.setBounds(1077, 226, 130, 30);
		//상세 보기 라벨
		productInfoLabel = new JLabel("- 상품 상세 정보");
		productInfoLabel.setFont(new Font("굴림", Font.BOLD, 15));
		productInfoLabel.setBounds(921, 266, 150, 25);

		productIdLabel = new JLabel("상품 ID");
		productIdLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productIdLabel.setBounds(925, 295, 70, 25);

		productNameLabel = new JLabel("상품 이름");
		productNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		productNameLabel.setBounds(925, 330, 70, 25);

		supplierNameLabel = new JLabel("생산 기업명");
		supplierNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		supplierNameLabel.setBounds(925, 435, 80, 25);

		mainCategoryLabel = new JLabel("대분류");
		mainCategoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		mainCategoryLabel.setBounds(925, 365, 70, 25);

		subCategoryLabel = new JLabel("소분류");
		subCategoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		subCategoryLabel.setBounds(925, 400, 70, 25);

		storePriceLabel = new JLabel("입고 금액");
		storePriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		storePriceLabel.setBounds(925, 470, 80, 25);

		sellingPriceLabel = new JLabel("출고 금액");
		sellingPriceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		sellingPriceLabel.setBounds(925, 505, 80, 25);

		inventoryLabel = new JLabel("상품 재고");
		inventoryLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		inventoryLabel.setBounds(925, 540, 80, 25);

		//상세보기 Text
		productIdText = new JTextField();
		productIdText.setBounds(1007, 295, 200, 25);
		productIdText.setColumns(10);

		productNameText = new JTextField();
		productNameText.setColumns(10);
		productNameText.setBounds(1007, 330, 200, 25);

		supplierNameCombo = new JComboBox();
		supplierNameCombo.setBounds(1007, 435, 200, 25);
		supplierNameCombo.setModel(new DefaultComboBoxModel(supplierList));

		storePriceText = new JTextField();
		storePriceText.setEnabled(false);
		storePriceText.setColumns(10);
		storePriceText.setBounds(1007, 470, 200, 25);

		sellingPriceText = new JTextField();
		sellingPriceText.setEnabled(false);
		sellingPriceText.setColumns(10);
		sellingPriceText.setBounds(1007, 505, 200, 25);

		inventoryText = new JTextField();
		inventoryText.setEnabled(false);
		inventoryText.setColumns(10);
		inventoryText.setBounds(1007, 540, 200, 25);

		mainCategoryCombo = new JComboBox();
		mainCategoryCombo.setBounds(1007, 367, 200, 23);

		subCategoryCombo = new JComboBox();
		subCategoryCombo.setBounds(1007, 402, 200, 23);


		mainCategoryCombo.setModel(new DefaultComboBoxModel(mainCategories));
		subCategoryCombo.setModel(new DefaultComboBoxModel(subCategories));
		//상품 상세 수정 버튼
		saveButton = new JButton("저장");
		saveButton.setBounds(925, 575, 130, 30);

		updateButton = new JButton("수정");
		updateButton.setBounds(1077, 575, 130, 30);

		//상품 삭제 버튼
		deleteButton = new JButton("삭제");
		deleteButton.setBounds(783, 65, 130, 30);
		productInfoResetButton = new JButton("초기화");
		productInfoResetButton.setBounds(641, 65, 130, 30);
	}

	private void setDisplay(){
		mainPanel.setLayout(null);

		//조회 관련 컴포넌트 패널 추가
		mainPanel.add(productIdText);
		mainPanel.add(productNameText);
		mainPanel.add(supplierSearchCombo);
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
		mainPanel.add(updateButton);
		mainPanel.add(productInfoLabel);

		//상품 검색
		mainPanel.add(productSearchLabel);
		mainPanel.add(idSearchLabel);
		mainPanel.add(idSearchText);
		mainPanel.add(nameSearchLabel);
		mainPanel.add(nameSearchText);
		mainPanel.add(supplierNameCombo);
		mainPanel.add(supplierSearchLabel);
		mainPanel.add(mainCategorySearchLabel);
		mainPanel.add(searchButton);
		mainPanel.add(deleteButton);
		mainPanel.add(mainCategorySearchCombo);
		mainPanel.add(subCategoryLabel);
		mainPanel.add(subCategoryCombo);
		mainPanel.add(searchResetButton);
		mainPanel.add(productInfoResetButton);
		mainPanel.add(subCategorySearchLabel);
		mainPanel.add(subCategorySearchCombo);


		//테이블 설정
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10); // Set width for checkbox column
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Enable multiple selections
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 105, 900, 500); // Adjust bounds as needed
		mainPanel.add(scrollPane);
		;

	}

	void setComponentData(){
		ProductSearch search = ProductSearch.builder().build();
		List<ProductInfo> products = productService.search(search);
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

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) { // Ensure this event is not fired multiple times
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) { // Check if a row is selected

						ProductInfo productInfo = ProductInfo.builder()
								.id((Long) table.getValueAt(selectedRow, 1))
								.productName((String) table.getValueAt(selectedRow, 2))
								.categoryId((Long) table.getValueAt(selectedRow, 3))
								.categoryName((String) table.getValueAt(selectedRow, 4))
								.supplierId((Long) (table.getValueAt(selectedRow, 5)))
								.supplierName((String) table.getValueAt(selectedRow, 6))
								.storePrice((Integer) (table.getValueAt(selectedRow, 7) != null ? table.getValueAt(selectedRow, 7) : 0))
								.sellingPrice((Integer) (table.getValueAt(selectedRow, 8) != null ? table.getValueAt(selectedRow, 8) : 0))
								.inventory((Integer) (table.getValueAt(selectedRow, 9) != null ? table.getValueAt(selectedRow, 9) : 0))
								.build();

						int supplierIdx = ((DefaultComboBoxModel<String>) supplierNameCombo.getModel()).getIndexOf(productInfo.getSupplierName());
						int categoryIdx = ((DefaultComboBoxModel<String>) subCategoryCombo.getModel()).getIndexOf(productInfo.getCategoryName());

						productIdText.setText(productInfo.getId().toString());
						productNameText.setText(productInfo.getProductName());
						supplierNameCombo.setSelectedIndex(supplierIdx);
						subCategoryCombo.setSelectedIndex(categoryIdx);
						storePriceText.setText(productInfo.getStorePrice().toString());
						sellingPriceText.setText(productInfo.getSellingPrice().toString());
						inventoryText.setText(productInfo.getInventory().toString());
					}
				}
			}
		});
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String supplierName = supplierNameCombo.getSelectedItem().toString();
				String categoryName = subCategoryCombo.getSelectedItem().toString();
				Category category = categoryService.getCategory(categoryName);
				ProductCreate productCreate = ProductCreate.builder()
						.productName(productNameText.getText())
						.supplierName(supplierName)
						.categoryId(category.getCategoryId())
						.build();

//				productName(productNameText.getText())
//						.supplierName(supplierNameCombo.getSelectedItem().toString())
//						.categoryId(category.getCategoryId())
//						.build();
				productService.save(productCreate);
				tableRefresh();
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(productIdText.getText());
				String productName = productNameText.getText();
				String supplierName = supplierNameCombo.getSelectedItem().toString();
				String categoryName = subCategoryCombo.getSelectedItem().toString();
				Category category = categoryService.getCategory(categoryName);

				Product product = productService.get(id);
				ProductEdit productEdit = ProductEdit.builder()
						.productName(productName)
						.categoryId(category.getCategoryId())
						.supplierName(supplierName)
						.build();

				productService.edit(id,productEdit);
				tableRefresh();
			}
		});

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Long id = null;
				TryParse.tryParseLong(idSearchText.getText(),id);
				String productName = nameSearchText.getText();
				String supplierName = supplierSearchCombo.getSelectedItem().toString();
				String categoryName = subCategorySearchCombo.getSelectedItem().toString();
				//Category category = categoryService.getCategory(categoryName);

				ProductSearch productSearch = ProductSearch.builder()
						.id(id)
						.productName(productName)
						.categoryName(categoryName)
						.supplierName(supplierName)
						.build();
				List<ProductInfo> searchProducts = productService.search(productSearch);
				Object[][] data = searchProducts.stream()
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
				table.setModel(model);
			}
		});

		productInfoResetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[][] data={};
				model = new DefaultTableModel(data, columnNames) {
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
					}
				};
				table.setModel(model);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = table.getSelectedRows();
				List<ProductInfo> deletedProducts = IntStream.range(0, table.getRowCount()) // Stream of row indices
						.filter(row -> (boolean) table.getValueAt(row, 0)) // Filter to keep only selected rows
						.mapToObj(row -> {
							Long id = (Long) table.getValueAt(row, 1);
							String productName = (String) table.getValueAt(row, 2);
							Long categoryId = (Long) table.getValueAt(row, 3);
							String categoryName = (String) table.getValueAt(row, 4);
							Long supplierId = (Long) table.getValueAt(row, 5);
							String supplierName = (String) table.getValueAt(row, 6);
							Integer storePrice = (Integer) table.getValueAt(row, 7);
							Integer sellingPrice = (Integer) table.getValueAt(row, 8);
							Integer inventory = (Integer) table.getValueAt(row, 9);

							return ProductInfo.builder()
									.id(id)
									.productName(productName)
									.categoryId(categoryId)
									.categoryName(categoryName)
									.supplierId(supplierId)
									.supplierName(supplierName)
									.storePrice(storePrice)
									.sellingPrice(sellingPrice)
									.inventory(inventory)
									.build();
						})
						.collect(Collectors.toList());
				productService.delete(deletedProducts);
				tableRefresh();
			}
		});
	}

	public void tableRefresh(){
		ProductSearch search = ProductSearch.builder().build();
		List<ProductInfo> products = productService.search(search);
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
		table.setModel(model);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public ProductApp() {
		AppConfig appConfig = new AppConfig();
		productService = appConfig.productService();
		categoryService = appConfig.categoryService();
		supplierService = appConfig.supplierService();

//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			setBounds(100, 100, 1280, 720); // Adjusted for HD resolution (16:9 aspect ratio)
		setComponentData();
		initComponent();
		setDisplay();
		setListenerEvent();
//		setLocationRelativeTo(null);
//		setVisible(true);
	}
}