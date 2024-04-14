package main.com.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	String[] search = {"출고 번호", "출고 상태"};
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(53, 165, 524, 474);
		contentPane.add(table);
		
		comboBox = new JComboBox(search);
		comboBox.setBounds(74, 79, 123, 33);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(253, 79, 123, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Searchbtn = new JButton("검색");
		Searchbtn.setBounds(454, 56, 91, 72);
		Searchbtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Searchbtn);
		
		Enrollbtn = new JButton("주문 등록");
		Enrollbtn.setBounds(628, 73, 171, 55);
		Enrollbtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Enrollbtn);
		
		Updatebtn = new JButton("수정");
		Updatebtn.setBounds(846, 73, 171, 55);
		Updatebtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Updatebtn);
		
		Deletebtn = new JButton("주문 삭제");
		Deletebtn.setBounds(1061, 73, 171, 55);
		Deletebtn.setFont(new Font("고딕", Font.BOLD, 20));
		contentPane.add(Deletebtn);
	
		//이벤트 처리
		Enrollbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // 새로운 창을 생성하여 표시
		        NewOrderFrame newOrderFrame = new NewOrderFrame();
		        newOrderFrame.setVisible(true);
		    }

			
		});
	
	
	}
	
	
	
}
