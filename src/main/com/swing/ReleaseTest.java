package main.com.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;
import main.com.release.dto.ReleaseDTO;
import main.com.release.service.ReleaseService;
import main.com.release.service.ReleaseServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ReleaseTest extends JFrame {
	JComboBox comboBox;
	JButton Enrollbtn;
	JButton Searchbtn;
	JButton Updatebtn;
	JButton Deletebtn;
	JButton detailbtn;
	
	private JPanel contentPane;
	private JTextField textField;
	String[] search = {"출고 번호", "출고 상태"};
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseTest frame = new ReleaseTest();
					frame.setSize(1280, 720);
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
	public ReleaseTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 212, 509, 408);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String [] header = {"출고번호","담당자ID","출고수량","출고일자","출고상태"};
		DefaultTableModel model = new DefaultTableModel(null, header);
        table.setModel(model);
        // 헤더의 DefaultTableCellRenderer 가져오기
        JTableHeader headerComponent = table.getTableHeader();
        TableCellRenderer headerRenderer = headerComponent.getDefaultRenderer();

        //헤더의 글자 크기를 변경
        TableCellRenderer customHeaderRenderer = (table1, value, isSelected, hasFocus, row, column) -> {
            JLabel label = (JLabel) headerRenderer.getTableCellRendererComponent(table1, value, isSelected, hasFocus, row, column);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 16)); // 글자 크기 변경
            return label;
        };

        headerComponent.setDefaultRenderer(customHeaderRenderer);

		comboBox = new JComboBox(search);
		comboBox.setBounds(63, 134, 123, 33);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(253, 134, 123, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Searchbtn = new JButton("검색");
		Searchbtn.setBounds(446, 127, 99, 33);
		Searchbtn.setFont(new Font("고딕", Font.BOLD, 15));
		contentPane.add(Searchbtn);
		
		Enrollbtn = new JButton("주문 등록");
		Enrollbtn.setBounds(619, 145, 171, 55);
		Enrollbtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Enrollbtn);
		
		Updatebtn = new JButton("수정");
		Updatebtn.setBounds(847, 145, 171, 55);
		Updatebtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Updatebtn);
		
		Deletebtn = new JButton("주문 삭제");
		Deletebtn.setBounds(1068, 145, 171, 55);
		Deletebtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Deletebtn);
		
      
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(643, 231, 568, 389);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		String [] header1 = {"주문번호","상품ID","상품명","주문수량","기업명","주문일자"};
		DefaultTableModel model1 = new DefaultTableModel(null, header1);
        table_1.setModel(model1);
        
        detailbtn = new JButton("상세보기");
        detailbtn.setBounds(446, 170, 99, 32);
        detailbtn.setFont(new Font("고딕", Font.BOLD, 15));
        contentPane.add(detailbtn);
		//주문 생성
		Enrollbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 새로운 창을 생성하여 표시
		        NewOrderFrame newOrderFrame = new NewOrderFrame();
		        newOrderFrame.setVisible(true);
		    }

			
		});
		
		//검색
		// 검색 버튼에 대한 ActionListener 설정
		Searchbtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedOption = (String) comboBox.getSelectedItem();
		        
		        //검색어
		        String searchText = textField.getText().trim();
		        
		        // 선택된 검색 옵션과 textField 입력값에 따라 검색 수행
		        switch (selectedOption) {
		            case "출고 번호":
		                if (!searchText.isEmpty()) {
		                    int searchtext = Integer.parseInt(searchText);
		                    ReleaseService service = new ReleaseServiceImpl();
		                    List<ReleaseDTO> list = service.noselect(searchtext);
		                    System.out.println(list);

		                    DefaultTableModel model = (DefaultTableModel) table.getModel();


		                    model.setRowCount(0);



		                    for (ReleaseDTO release : list) {
		                        Object[] rowData = {
		                            release.getId(),
		                            release.getMember_id(),
		                            release.getItem_cnt(),
		                            release.getRelease_date(),
		                            release.getStatus()
		                        };
//		                        System.out.println(rowData[2]);
		                        model.addRow(rowData);
		                    }
		                     
		                } else {
		                	JOptionPane.showMessageDialog(null, "출고번호를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
		                }
		                break;
		                
		            case "출고 상태":
		                if (!searchText.isEmpty()) {
		                	String searchtext = searchText;
		                    ReleaseService service = new ReleaseServiceImpl();
		                    List<ReleaseDTO> list = service.statuselect(searchtext);
		                    System.out.println(list);

		                    DefaultTableModel model = (DefaultTableModel) table.getModel();


		                    model.setRowCount(0);



		                    for (ReleaseDTO release : list) {
		                        Object[] rowData = {
		                            release.getId(),
		                            release.getMember_id(),
		                            release.getItem_cnt(),
		                            release.getRelease_date(),
		                            release.getStatus()
		                        };
//		                        System.out.println(rowData[2]);
		                        model.addRow(rowData);
		                    }
		                } else {
		                    // textField가 비어있을 경우 메시지 출력
		                	JOptionPane.showMessageDialog(null, "출고상태 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
		                }
		                break;
		                
		            default:
		                // 선택된 옵션이 없는 경우 메시지 출력
		                System.out.println("검색 옵션을 선택하세요.");
		                break;
		        }
		    }
		});
		
		
		//상세보기(출고 눌렀을 때 안에 어떤 주문들이 있는지)
		detailbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 인덱스 가져오기
		    	int selectedRowIndex = table.getSelectedRow();
		    	long releaseid = (long) table.getValueAt(selectedRowIndex, 0); // 출고번호 가져오기
//		    	int releaseIdInt = (int) releaseid;
		    	OrderService order = new OrderServiceImpl();
		    	List<OrderDTO> list = order.orderselect(releaseid);
		    	System.out.println(list);
		    	OrderDTO oid = list.get(0);
		    	OrderDTO pid = list.get(2);
		    	String pname = order.productselect(pid);
		    	OrderDTO cnt = list.get(4);
		    	OrderDTO cid = list.get(5);
                String cname = order.companyselect(cid);
                OrderDTO date = list.get(3);
                Object[] rowData = {
                		oid,
                		pid,
                		pname,
                		cnt,
                		cname,
                		date
                     };
                 // 기업이 등록되지 않은 경우에만 테이블에 추가
                model1.addRow(rowData);
               
		    	
		    }

			
		});
	}}
