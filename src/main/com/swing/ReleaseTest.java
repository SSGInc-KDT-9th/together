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

import main.com.order.dao.OrderDAO;
import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;
import main.com.release.dao.ReleaseDAO;
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
import java.awt.Color;
import javax.swing.SwingConstants;

public class ReleaseTest extends JFrame {
	JButton Enrollbtn;
	JButton Searchbtn;
	JButton Updatebtn;
	JButton Deletebtn;
	JButton detailbtn;
	
	private JPanel contentPane;
	String[] search = {"출고 번호", "출고 상태"};
	String[] search2 = {"선택", "대기중", "출고 완료"};
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
        
        JLabel lblNewLabel = new JLabel("출고 상태");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(88, 145, 103, 35);
        lblNewLabel.setFont(new Font("고딕", Font.BOLD, 16));
        contentPane.add(lblNewLabel);
        
        JComboBox comboBox_1 = new JComboBox(search2);
        comboBox_1.setBounds(223, 147, 125, 33);
        Font font = new Font("고딕", Font.PLAIN, 15); 
        comboBox_1.setFont(font);
        contentPane.add(comboBox_1);
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
		        String selectedOption = (String) comboBox_1.getSelectedItem();
		        
		        
		        String searchtext = selectedOption;
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
		              if(searchtext=="선택") {
		            	 ReleaseService service2 = new ReleaseServiceImpl();
		  		        List<ReleaseDTO> list2 = service2.findall();
		  		        System.out.println(list2);
		  		        model.setRowCount(0);
		  		              for (ReleaseDTO release : list2) {
		  		            	  Object[] rowData = {
		  		                            release.getId(),
		  		                            release.getMember_id(),
		  		                            release.getItem_cnt(),
		  		                            release.getRelease_date(),
		  		                            release.getStatus()
		  		                        };
		  		                        model.addRow(rowData);
		  		                    }
		                }
		              
		    }
		    
		    
		      
		});
		
		
		//상세보기(출고 눌렀을 때 안에 어떤 주문들이 있는지)
		detailbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 인덱스 가져오기
		    	int selectedRowIndex = table.getSelectedRow();
		    	long releaseid = (long) table.getValueAt(selectedRowIndex, 0); // 출고번호 가져오기
		    	
		    	model1.setRowCount(0);
		    	
//		    	int releaseIdInt = (int) releaseid;
//		    	System.out.println(releaseid);
		    	OrderService order = new OrderServiceImpl();
		    	List<OrderDTO> list = order.orderselect(releaseid);
		    	System.out.println(list);
		    	for (OrderDTO order1 : list) {
                    Object[] rowData = {
                    	order1.getId(),
                        order1.getRelease_id(),
                        order1.getProduct_id(),
                        order1.getOrder_cnt(),
                        order1.getOrder_date(),
                        order1.getClient_id()
                    };
                    System.out.println(rowData[2]);
                    int pid = (int) rowData[2];
                    String pname = order.productselect(pid);
                    int cid = (int) rowData[5];
                    String cname = order.companyselect(cid);
                    
                    Object[] result = {
                            rowData[0],
                            pid,
                            pname,
                            rowData[3],
                            cname,
                            rowData[4]
                        };
//                      System.out.println(rowData[2]);
                        model1.addRow(result);
                }

		    }

			
		});
		//삭제 버튼
		Deletebtn.addActionListener(new ActionListener() {
							
		@Override
		public void actionPerformed(ActionEvent e) {

			// 주문 목록 삭제
			int selectedRowIndex1 = table_1.getSelectedRow();
			if (selectedRowIndex1 != -1 && model1 != null) {
			    // 삭제 여부 확인 대화 상자 표시
			    int option1 = JOptionPane.showConfirmDialog(null, "주문을 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
			    if (option1 == JOptionPane.YES_OPTION) {
			        // 확인을 선택한 경우
			        int orderid = (int) table_1.getValueAt(selectedRowIndex1, 0); // 주문번호 가져오기
			        OrderService order = new OrderServiceImpl();
			        order.setDao(new OrderDAO());
			        int n3 = order.orderdelete(orderid);
			      
			        model1.removeRow(selectedRowIndex1);
			    }
			    return;
			}

			// 출고 목록 삭제
			int selectedRowIndex2 = table.getSelectedRow();
			if (selectedRowIndex2 != -1 && model != null) {
			    // 삭제 여부 확인 대화 상자 표시
			    int option2 = JOptionPane.showConfirmDialog(null, "출고를 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
			    if (option2 == JOptionPane.YES_OPTION) {
			        //확인을 선택한 경우
			        long releaseid = (long) table.getValueAt(selectedRowIndex2, 0); // 출고번호 가져오기
			        ReleaseService rs = new ReleaseServiceImpl();
			        rs.setDao(new ReleaseDAO());
			        int n4 = rs.releasedelete(releaseid);
			        
			        model.removeRow(selectedRowIndex2);
			    }
			}}
	});
			
		
		}	
}
