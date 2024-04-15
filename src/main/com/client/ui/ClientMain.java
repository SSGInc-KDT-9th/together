package main.com.client.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.com.client.dao.ClientDAO;
import main.com.client.dto.ClientDTO;
import main.com.client.service.ClientService;
import main.com.client.service.ClientServiceImpl;

public class ClientMain extends JFrame {
	
	private JPanel contentPane;
	private JTextField selectid;
	private JTextField selectCompanyName;
	private JTextField tfid;
	private JTextField tfcompanyName;
	private JTextField tfincome;
	private JTextField tfaddress;
	private JComboBox tfcategory;
	private JTextField deleteid;
	private JButton btnsave;
	private JButton btndelete;
	private JTable table;
	private JButton btnreset;
	String[] ClientCategory = { "백화점", "대형마트","편의점","슈퍼마켓","무인매장" };
	
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
		
		
		//개발시작
		JPanel panel = new JPanel();
		panel.setBounds(915, 90, 339, 257);
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
		btnsave.setBounds(236, 224, 91, 23);
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
		
		tfincome = new JTextField();
		tfincome.setColumns(10);
		tfincome.setBounds(76, 141, 178, 21);
		panel.add(tfincome);
		
		tfaddress = new JTextField();
		tfaddress.setColumns(10);
		tfaddress.setBounds(76, 181, 178, 21);
		panel.add(tfaddress);
		
		tfcategory = new JComboBox(ClientCategory);
		tfcategory.setBackground(new Color(255, 255, 255));
		tfcategory.setBounds(76, 106, 178, 23);
		panel.add(tfcategory);
		
		btnreset = new JButton("초기화");
		btnreset.setBounds(127, 224, 91, 23);
		panel.add(btnreset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(915, 380, 339, 86);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("삭제할 기업 id를 입력하시오");
		lblNewLabel_1_1_1_1.setBounds(12, 10, 277, 15);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		btndelete = new JButton("삭제");
		btndelete.setBounds(236, 53, 91, 23);
		panel_1.add(btndelete);
		
		deleteid = new JTextField();
		deleteid.setColumns(10);
		deleteid.setBounds(12, 35, 178, 21);
		panel_1.add(deleteid);
		
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
		
		selectid = new JTextField();
		selectid.setBounds(70, 18, 178, 21);
		panel_3.add(selectid);
		selectid.setColumns(10);
		
		selectCompanyName = new JTextField();
		selectCompanyName.setColumns(10);
		selectCompanyName.setBounds(347, 18, 178, 21);
		panel_3.add(selectCompanyName);
		
		JButton btnFind = new JButton("조회");
		btnFind.setBounds(537, 17, 91, 23);
		panel_3.add(btnFind);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(727, 21, 138, 32);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnFindAll = new JButton("전체조회");
		btnFindAll.setBounds(30, 5, 77, 23);
		panel_2.add(btnFindAll);
		
		//메인 테이블 창 구성
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 87, 843, 548);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	     
        Vector<String> v = new Vector<>();
		
		String [] header = {"기업 ID","기업명","분류","거래액 (단위: 만원)","주소"};
		String [][] obj = {};
		
		DefaultTableModel dm = new DefaultTableModel(obj, header);
		table.setModel(dm);
		//end
		
		//초기화 버튼 이벤트 처리
		btnreset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfid.setText("");
				tfcategory.setSelectedItem(ClientCategory[0]);
				tfcompanyName.setText("");
				tfincome.setText("");
				tfaddress.setText("");
				
			}
		});
		
		
		//전체조회 버튼 이벤트 처리
		btnFindAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ClientService service = new ClientServiceImpl();
				service.setDao(new ClientDAO());
				
				 List<ClientDTO> list = service.findAll();
				 
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				 model.setRowCount(0);
				 
                 for (ClientDTO client : list) {
                	 Object[] rowData = {
                             client.getId(),
                             client.getCompany_name(),
                             client.getCategory(),
                             client.getIncome(),
                             client.getAddress()
                         };
                         model.addRow(rowData);
			}
			}
		});//end
		
		//기업 id 입력시 정보 조회 버튼 이벤트 처리
		btnFind.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String id = selectid.getText();

		        if (!id.isEmpty()) { 
		            ClientService service = new ClientServiceImpl();
		            service.setDao(new ClientDAO());

		            ClientDTO client = service.findById(Integer.parseInt(id));
		            if (client != null) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                model.setRowCount(0); 

		                Object[] rowData = {
		                        client.getId(),
		                        client.getCompany_name(),
		                        client.getCategory(),
		                        client.getIncome(),
		                        client.getAddress()
		                };
		                model.addRow(rowData);
		            } else {
		                JOptionPane.showMessageDialog(null, "해당 ID에 대한 데이터를 찾을 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            System.out.println("ID를 입력해주세요.");
		        }
		    }
		});
			
		//기업명 입력시 정보 조회 버튼 이벤트 처리
		btnFind.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String companyName = selectCompanyName.getText();

		        if (!companyName.isEmpty()) { // 기업명이 비어있지 않은 경우에만 실행
		            ClientService service = new ClientServiceImpl();
		            service.setDao(new ClientDAO());

		            List<ClientDTO> clients = service.findByCompanyName(companyName);
		            if (!clients.isEmpty()) {
		                DefaultTableModel model = (DefaultTableModel) table.getModel();
		                model.setRowCount(0); // 기존 데이터 초기화

		                for (ClientDTO client : clients) {
		                    Object[] rowData = {
		                            client.getId(),
		                            client.getCompany_name(),
		                            client.getCategory(),
		                            client.getIncome(),
		                            client.getAddress()
		                    };
		                    model.addRow(rowData);
		                }
		            } else {
		                System.out.println("해당 기업명에 대한 데이터를 찾을 수 없습니다.");
		            }
		        } else {
		            System.out.println("기업명을 입력해주세요.");
		        }
		    }
		});

		
		//기업 고객 등록 버튼 이벤트 처리
		btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String company_name = tfcompanyName.getText();
				String category = tfcategory.getSelectedItem().toString();
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
				
				JOptionPane.showInternalMessageDialog(null, n+"개가 저장됨",
			             "저장", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});//end
		
		//id를 통한 기업 고객 삭제 버튼 이벤트 처리
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = deleteid.getText();
				
				ClientDTO dto = new ClientDTO();
				dto.setId(Integer.parseInt(id));
				
				ClientService service = new ClientServiceImpl();
				service.setDao(new ClientDAO());
				
				int n = service.removeByid(Integer.parseInt(id));
				System.out.println(n+"개가 삭제됨");
				
				 Object[] options = { "OK", "CANCEL" };
				 JOptionPane.showOptionDialog(null, "입력하신 기업을 삭제하시겠습니까?", "Warning",
				             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				             null, options, options[0]);
			}
		});//end
		

		
	}
}
