package main.com.supplier.ui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.com.supplier.domain.Supplier;
import main.com.supplier.repository.SupplierDAO;
import main.com.supplier.service.SupplierService;
import main.com.supplier.service.SupplierServiceImpl;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;

public class SupplierMain extends JFrame {

	private JPanel contentPane;
	private JButton FindAllBtn;
	private JButton insertBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton resetBtn;
	private JTable table;
	private JTextField insert_company_name;
	private JTextField insert_company_category;
	private JTextField insert_income;
	private JTextArea insert_address;
	
	private JTextField side_company_name;
	private JTextField side_company_category;
	private JTextField side_income;
	private JTextArea side_address;
	
	private JButton top_resetBtn;
	private JTextField top_company_name;
	private JTextField top_company_category;
	private JTextField top_address;
	private JPanel seachPanel;
	private JPanel insertPanel;
	private JPanel updatePanel;

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

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 114, 950, 550);
		contentPane.add(scrollPane);

		// 테이블 생성
		table = new JTable();
		scrollPane.setViewportView(table);

		insertPanel = new JPanel();
		insertPanel.setToolTipText("");
		insertPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC5C5\uCCB4\uCD94\uAC00", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		insertPanel.setBounds(974, 417, 278, 250);
		contentPane.add(insertPanel);
		insertPanel.setLayout(null);
		
//		insert

		insertBtn = new JButton("추가하기");
		insertBtn.setBounds(74, 210, 90, 30);
		insertPanel.add(insertBtn);
		insertBtn.setFont(new Font("굴림", Font.BOLD, 12));

		resetBtn = new JButton("초기화");
		resetBtn.setBounds(176, 210, 90, 30);
		insertPanel.add(resetBtn);
		resetBtn.setFont(new Font("굴림", Font.BOLD, 12));

		insert_company_name = new JTextField();
		insert_company_name.setBounds(116, 30, 150, 20);
		insertPanel.add(insert_company_name);
		insert_company_name.setColumns(10);

		JLabel lblNewLabel = new JLabel("기업명");
		lblNewLabel.setBounds(12, 30, 60, 20);
		insertPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel("업종");
		lblNewLabel_1.setBounds(12, 60, 60, 20);
		insertPanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_2 = new JLabel("거래액");
		lblNewLabel_2.setBounds(12, 90, 60, 20);
		insertPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setBounds(12, 120, 60, 20);
		insertPanel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));

		insert_income = new JTextField();
		insert_income.setBounds(116, 90, 150, 20);
		insertPanel.add(insert_income);
		insert_income.setColumns(10);
		
		insert_company_category = new JTextField();
		insert_company_category.setBounds(116, 60, 150, 20);
		insertPanel.add(insert_company_category);
		insert_company_category.setColumns(10);
		
		insert_address = new JTextArea();
		insert_address.setLineWrap(true);
		insert_address.setBounds(116, 118, 150, 82);
		insertPanel.add(insert_address);

		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				insert_company_name.setText("");
				insert_company_category.setText("");
				insert_income.setText("");
				insert_address.setText("");

			}
		});

		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String text1 = insert_company_name.getText();
				String text2 = insert_company_category.getText();
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
				insert_company_category.setText("");
				insert_income.setText("");
				insert_address.setText("");

				DisplaySupllierData();

			}
		});

		updatePanel = new JPanel();
		updatePanel.setForeground(new Color(0, 0, 0));
		updatePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC218\uC815 \uBC0F \uC0AD\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		updatePanel.setToolTipText("");
		updatePanel.setBounds(974, 108, 280, 250);
		contentPane.add(updatePanel);
		updatePanel.setLayout(null);

		JLabel lblNewLabel_8_3 = new JLabel("기업명");
		lblNewLabel_8_3.setBounds(12, 30, 60, 20);
		updatePanel.add(lblNewLabel_8_3);
		lblNewLabel_8_3.setFont(new Font("굴림", Font.BOLD, 15));

		deleteBtn = new JButton("삭제하기");
		deleteBtn.setBounds(178, 210, 90, 30);
		updatePanel.add(deleteBtn);
		deleteBtn.setFont(new Font("굴림", Font.BOLD, 12));

		updateBtn = new JButton("수정하기");
		updateBtn.setBounds(76, 210, 90, 30);
		updatePanel.add(updateBtn);
		updateBtn.setFont(new Font("굴림", Font.BOLD, 12));

		JLabel lblNewLabel_8_4 = new JLabel("업종");
		lblNewLabel_8_4.setBounds(12, 60, 60, 20);
		updatePanel.add(lblNewLabel_8_4);
		lblNewLabel_8_4.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_8_5 = new JLabel("거래액");
		lblNewLabel_8_5.setBounds(12, 90, 60, 20);
		updatePanel.add(lblNewLabel_8_5);
		lblNewLabel_8_5.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblNewLabel_8_6 = new JLabel("주소");
		lblNewLabel_8_6.setBounds(12, 120, 60, 20);
		updatePanel.add(lblNewLabel_8_6);
		lblNewLabel_8_6.setFont(new Font("굴림", Font.BOLD, 15));

		side_company_name = new JTextField();
		side_company_name.setBounds(118, 30, 150, 20);
		updatePanel.add(side_company_name);
		side_company_name.setEditable(false);
		side_company_name.setColumns(10);

		side_company_category = new JTextField();
		side_company_category.setBounds(118, 60, 150, 20);
		updatePanel.add(side_company_category);
		side_company_category.setEditable(false);
		side_company_category.setColumns(10);

		side_income = new JTextField();
		side_income.setBounds(118, 90, 150, 20);
		updatePanel.add(side_income);
		side_income.setEditable(false);
		side_income.setColumns(10);
		
		side_address = new JTextArea();
		side_address.setBackground(new Color(255, 255, 255));
		side_address.setLineWrap(true);
		side_address.setEditable(false);
		side_address.setBounds(118, 118, 150, 82);
		updatePanel.add(side_address);

		seachPanel = new JPanel();
		seachPanel.setBounds(12, 65, 950, 40);
		contentPane.add(seachPanel);
		seachPanel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("기업명");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(12, 10, 50, 20);
		seachPanel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("굴림", Font.BOLD, 15));

		top_company_name = new JTextField();
		top_company_name.setBounds(84, 10, 150, 22);
		seachPanel.add(top_company_name);
		top_company_name.setColumns(10);

		JLabel lblNewLabel_8_1 = new JLabel("업종");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setBounds(246, 10, 50, 20);
		seachPanel.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setFont(new Font("굴림", Font.BOLD, 15));

		top_company_category = new JTextField();
		top_company_category.setBounds(308, 10, 150, 20);
		seachPanel.add(top_company_category);
		top_company_category.setColumns(10);

		JLabel lblNewLabel_8_2 = new JLabel("주소");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_2.setBounds(484, 10, 50, 20);
		seachPanel.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setFont(new Font("굴림", Font.BOLD, 15));

		top_address = new JTextField();
		top_address.setBounds(546, 10, 150, 20);
		seachPanel.add(top_address);
		top_address.setColumns(10);

		FindAllBtn = new JButton("조회");
		FindAllBtn.setBounds(860, 5, 90, 30);
		seachPanel.add(FindAllBtn);
		FindAllBtn.setFont(new Font("굴림", Font.BOLD, 12));
		
		top_resetBtn = new JButton("초기화");
		top_resetBtn.setFont(new Font("굴림", Font.BOLD, 12));
		top_resetBtn.setBounds(758, 5, 90, 30);
		seachPanel.add(top_resetBtn);

		FindAllBtn.addActionListener(new ActionListener() {
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
		
//		상단 검색부 리셋 버튼
		top_resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				top_company_name.setText("");
				top_company_category.setText("");
				top_address.setText("");
				
			}
		});

	}

//	전체 조회기능은 재활용 가능하게 따로 구현.
	public void DisplaySupllierData() {
		SupplierService service = new SupplierServiceImpl();
		service.setSup(new SupplierDAO());
		
		Supplier sup = new Supplier();
		if(!top_company_name.getText().equals("")) {
			sup.setCompany_name(top_company_name.getText());
		}
		if(!top_company_category.getText().equals("")) {
			sup.setCompany_category(top_company_category.getText());
		}
		if(!top_address.getText().equals("")) {
			sup.setAddress(top_address.getText());
		}
		
		List<Supplier> list = service.supplierFindAll(sup);

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
