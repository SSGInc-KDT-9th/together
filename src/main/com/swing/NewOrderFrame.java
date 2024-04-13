package main.com.swing;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;

public class NewOrderFrame extends JFrame {
	JLabel company_lbl;
	JLabel item_lbl;
	JLabel cnt_lbl;
	JComboBox cnt_combo;
	JButton inputbtn;
	JButton cancelbtn;
	JButton enrollbtn;
	
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	Integer[] itemCnt = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	private JButton deletebtn;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	public LocalDate getCurrentDate() {
	    return LocalDate.now();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewOrderFrame frame = new NewOrderFrame();
					frame.setSize(500, 500);
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
	public NewOrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 16); 
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 166, 428, 242);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		String [] header = {"client_id", "company_name", "product_name", "order_cnt","order_date"};
		DefaultTableModel model = new DefaultTableModel(null, header);
        table_1.setModel(model);
		company_lbl = new JLabel("기업명");
		company_lbl.setBounds(55, 35, 67, 35);
		company_lbl.setFont(font);
		contentPane.add(company_lbl);
		
		item_lbl = new JLabel("상품 이름");
		item_lbl.setBounds(194, 35, 74, 35);
		item_lbl.setFont(font);
		contentPane.add(item_lbl);
		
		cnt_lbl = new JLabel("주문 수량");
		cnt_lbl.setBounds(314, 37, 89, 31);
		cnt_lbl.setFont(font);
		contentPane.add(cnt_lbl);
		
		txt1 = new JTextField();
		txt1.setBounds(36, 80, 108, 35);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(170, 80, 125, 35);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		cnt_combo = new JComboBox(itemCnt);
		cnt_combo.setBounds(324, 78, 60, 29);
		contentPane.add(cnt_combo);

		
		inputbtn = new JButton("입력");
		inputbtn.setBounds(397, 78, 79, 29);
		contentPane.add(inputbtn);
		
		enrollbtn = new JButton("등록");
		enrollbtn.setBounds(301, 418, 91, 31);
		contentPane.add(enrollbtn);
		
		cancelbtn = new JButton("취소");
		cancelbtn.setBounds(397, 418, 79, 31);
		contentPane.add(cancelbtn);
		
		deletebtn = new JButton("삭제");
		deletebtn.setBounds(397, 41, 79, 29);
		contentPane.add(deletebtn);
		
		//서비스 구현
		
		cancelbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 창 닫기
		        dispose();
		    }
		});
		
		inputbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 입력된 정보를 테이블에 추가
                String companyName = txt1.getText();
                String productName = txt2.getText();
                int orderCnt = (Integer) cnt_combo.getSelectedItem();
                
//              OrderService를 사용하여 기업ID 조회
                OrderService orderService = new OrderServiceImpl();
                int clientId = orderService.findClientId(companyName);
                
//                if (clientId != 0) {
//                    // OrderDTO 객체 생성 및 정보 설정
//                    OrderDTO order = new OrderDTO();

                    // 테이블에 추가할 데이터 배열 생성
                    Object[] rowData = {
                       clientId,
                       companyName,
                       productName, 
                       orderCnt,
                       getCurrentDate()
                    };

                     //테이블 모델 가져오기
                    
                    
                    // 테이블 모델에 행 추가
                    model.addRow(rowData);
//                } else {
//                    // 기업ID가 존재하지 않는 경우 메시지 출력 또는 처리
//                    System.out.println("입력한 기업명에 해당하는 기업이 없습니다.");
//                }
            }
        });
	}
}
