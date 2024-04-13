package main.com.supplier.ui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;
import main.com.supplier.repository.SupplierService;
import main.com.supplier.repository.SupplierServiceImpl;
import main.com.supplier.domain.Supplier;
import main.com.supplier.domain.SupplierDAO;
import main.com.supplier.repository.SupplierService;
import main.com.supplier.repository.SupplierServiceImpl;


public class SupplierMain extends JFrame {

	private JPanel contentPane;
	private JButton selectBtn;
	private JButton insertBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton resetBtn;
	private JTable table;
	private JTextField insert_company_name;
	private JComboBox insert_company_category;
	private JTextField insert_income;
	private JTextField insert_address;
	private JTextField side_company_name;
	private JTextField side_company_category;
	private JTextField side_income;
	private JTextField side_address;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierMain frame = new SupplierMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SupplierMain() {
		setTitle("납품기업관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 114, 950, 550);
		contentPane.add(scrollPane);

		// 테이블 생성
		table = new JTable();
		scrollPane.setViewportView(table);

		String[] iceCreamCategory = { "아이스크림1", "아이스크림2" };

		panel = new JPanel();
		panel.setBounds(974, 414, 278, 250);
		contentPane.add(panel);
		panel.setLayout(null);

		insertBtn = new JButton("추가하기");
		insertBtn.setBounds(74, 210, 90, 30);
		panel.add(insertBtn);
		insertBtn.setFont(new Font("굴림", Font.BOLD, 12));

		resetBtn = new JButton("초기화");
		resetBtn.setBounds(176, 210, 90, 30);
		panel.add(resetBtn);
		resetBtn.setFont(new Font("굴림", Font.BOLD, 12));

		insert_address = new JTextField();
		insert_address.setBounds(116, 100, 150, 20);
		panel.add(insert_address);
		insert_address.setColumns(10);

		insert_company_name = new JTextField();
		insert_company_name.setBounds(116, 10, 150, 20);
		panel.add(insert_company_name);
		insert_company_name.setColumns(10);

		JLabel lblNewLabel = new JLabel("기업명");
		lblNewLabel.setBounds(12, 10, 60, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel("업종");
		lblNewLabel_1.setBounds(12, 40, 60, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_2 = new JLabel("거래액");
		lblNewLabel_2.setBounds(12, 70, 60, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(12, 100, 60, 20);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		insert_company_category = new JComboBox(iceCreamCategory);
		insert_company_category.setBounds(116, 40, 150, 20);
		panel.add(insert_company_category);

		insert_income = new JTextField();
		insert_income.setBounds(116, 70, 150, 20);
		panel.add(insert_income);
		insert_income.setColumns(10);

		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				insert_company_name.setText("");
				insert_company_category.setSelectedItem(iceCreamCategory[0]);
				insert_income.setText("");
				insert_address.setText("");

			}
		});

		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String text1 = insert_company_name.getText();
				String text2 = insert_company_category.getSelectedItem().toString();
				String text3 = insert_income.getText();
				String text4 = insert_address.getText();

				Supplier sup = new Supplier();

				sup.setCompany_name(text1);
				sup.setCompany_category(text2);
				sup.setIncome(Integer.parseInt(text3));
				sup.setAddress(text4);

				SupplierService service = new SupplierServiceImpl();
				service.setSup(new SupplierDAO());
				service.insert(sup);

				insert_company_name.setText("");
				insert_company_category.setSelectedItem(iceCreamCategory[0]);
				insert_income.setText("");
				insert_address.setText("");

				DisplaySupllierData();

			}
		});

		panel_1 = new JPanel();
		panel_1.setBounds(974, 114, 280, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_8_3 = new JLabel("기업명");
		lblNewLabel_8_3.setBounds(12, 10, 60, 20);
		panel_1.add(lblNewLabel_8_3);
		lblNewLabel_8_3.setFont(new Font("굴림", Font.BOLD, 15));

		deleteBtn = new JButton("삭제하기");
		deleteBtn.setBounds(178, 210, 90, 30);
		panel_1.add(deleteBtn);
		deleteBtn.setFont(new Font("굴림", Font.BOLD, 12));

		updateBtn = new JButton("수정하기");
		updateBtn.setBounds(76, 210, 90, 30);
		panel_1.add(updateBtn);
		updateBtn.setFont(new Font("굴림", Font.BOLD, 12));

		JLabel lblNewLabel_8_4 = new JLabel("업종");
		lblNewLabel_8_4.setBounds(12, 40, 60, 20);
		panel_1.add(lblNewLabel_8_4);
		lblNewLabel_8_4.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_8_5 = new JLabel("거래액");
		lblNewLabel_8_5.setBounds(12, 70, 60, 20);
		panel_1.add(lblNewLabel_8_5);
		lblNewLabel_8_5.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_8_6 = new JLabel("주소");
		lblNewLabel_8_6.setBounds(12, 100, 60, 20);
		panel_1.add(lblNewLabel_8_6);
		lblNewLabel_8_6.setFont(new Font("굴림", Font.BOLD, 15));

		side_company_name = new JTextField();
		side_company_name.setBounds(118, 10, 150, 20);
		panel_1.add(side_company_name);
		side_company_name.setEditable(false);
		side_company_name.setColumns(10);

		side_company_category = new JTextField();
		side_company_category.setBounds(118, 40, 150, 20);
		panel_1.add(side_company_category);
		side_company_category.setEditable(false);
		side_company_category.setColumns(10);

		side_income = new JTextField();
		side_income.setBounds(118, 70, 150, 20);
		panel_1.add(side_income);
		side_income.setEditable(false);
		side_income.setColumns(10);

		side_address = new JTextField();
		side_address.setBounds(118, 100, 150, 20);
		panel_1.add(side_address);
		side_address.setEditable(false);
		side_address.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 950, 94);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("기업명");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(15, 60, 50, 20);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 15));

		textField_4 = new JTextField();
		textField_4.setBounds(80, 58, 150, 22);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_8_1 = new JLabel("업종");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setBounds(250, 60, 50, 20);
		panel_2.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setFont(new Font("굴림", Font.BOLD, 15));

		textField_5 = new JTextField();
		textField_5.setBounds(315, 58, 150, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_8_2 = new JLabel("거래액");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_2.setBounds(485, 60, 50, 20);
		panel_2.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setFont(new Font("굴림", Font.BOLD, 15));

		textField_6 = new JTextField();
		textField_6.setBounds(550, 58, 150, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		selectBtn = new JButton("조회");
		selectBtn.setBounds(860, 55, 90, 30);
		panel_2.add(selectBtn);
		selectBtn.setFont(new Font("굴림", Font.BOLD, 12));

		selectBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				DisplaySupllierData();

			}
		});

		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
					String company_name = model.getValueAt(selectedRow, 1).toString();
					String company_category = model.getValueAt(selectedRow, 2).toString();
					long income = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
					String address = model.getValueAt(selectedRow, 4).toString();

					// 선택된 행의 정보를 가지고 Supllier 객체 생성
					Supplier sup = new Supplier(id, company_name, company_category, income, address);

					// SupllierUpdate 창을 열고, 생성된 Supllier 객체를 전달
					new SupplierUpdate(sup);

				} else {
					JOptionPane.showMessageDialog(null, "수정 할 항목을 선택하세요.");
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
					SupplierService service = new SupplierServiceImpl();
					service.setSup(new SupplierDAO());

					int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						service.delete(id);
					}
					// DB에서 조회하지 않고 테이블에서 보이는 행만 삭제할지 그냥 통으로 조회를 다시할지 결정할것.
					DisplaySupllierData();
//		            model.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(null, "삭제 할 항목을 선택하세요.");
				}
			}
		});

//		테이블 행을 클릭했을때 해당 행의 자료를 받아오는 기능. 어떻게 돌아가는건지 모르겠음.
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (!e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
						String company_name = model.getValueAt(selectedRow, 1).toString();
						String company_category = model.getValueAt(selectedRow, 2).toString();
						String address = model.getValueAt(selectedRow, 4).toString();

						side_company_name.setText(company_name);
						side_company_category.setText(company_category);
						side_income.setText(model.getValueAt(selectedRow, 3).toString());
						side_address.setText(address);
					}
				}
			}
		});

	}

//	전체 조회기능은 재활용 가능하게 따로 구현.
	private void DisplaySupllierData() {
		SupplierService service = new SupplierServiceImpl();
		service.setSup(new SupplierDAO());
		List<Supplier> list = service.findAll();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("ID");
		model.addColumn("Company Name");
		model.addColumn("Category");
		model.addColumn("Income");
		model.addColumn("Address");

		for (Supplier supplier : list) {
			model.addRow(new Object[] { supplier.getId(), supplier.getCompany_name(), supplier.getCompany_category(),
					supplier.getIncome(), supplier.getAddress() });
		}
		table.setModel(model);
	}
}
