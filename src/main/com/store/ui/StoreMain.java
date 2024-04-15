package main.com.store.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class StoreMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreMain frame = new StoreMain();
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
	public StoreMain() {
		setTitle("입고관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 120, 833, 528);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 10, 833, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("입고번호");
		lblNewLabel.setBounds(12, 35, 83, 24);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setBounds(107, 33, 180, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("입고상태");
		lblNewLabel_1.setBounds(338, 35, 91, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.PLAIN, 20));
		textField_1.setBounds(441, 33, 180, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.setBounds(674, 31, 101, 33);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(893, 10, 361, 418);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("상품ID");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(41, 27, 71, 30);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(220, 366, 98, 30);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("등록");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(51, 366, 98, 30);
		panel_1.add(btnNewButton_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 27, 141, 30);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("사용자ID");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(27, 77, 100, 30);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("입고일자");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(27, 129, 85, 30);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("입고수량");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(27, 184, 85, 30);
		panel_1.add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(124, 77, 141, 30);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("입고상태");
		lblNewLabel_2_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_1.setBounds(27, 234, 85, 30);
		panel_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("입고금액");
		lblNewLabel_2_3_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2.setBounds(27, 286, 85, 30);
		panel_1.add(lblNewLabel_2_3_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(124, 129, 141, 30);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(124, 184, 141, 30);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(124, 234, 141, 30);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(124, 286, 141, 30);
		panel_1.add(textField_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(893, 452, 361, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("입고번호");
		lblNewLabel_2_3_2_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2_3_2_1.setBounds(39, 80, 85, 30);
		panel_2.add(lblNewLabel_2_3_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("삭제");
		btnNewButton_1_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton_1_1_1.setBounds(142, 139, 98, 30);
		panel_2.add(btnNewButton_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(156, 80, 141, 30);
		panel_2.add(textField_8);
	}
}
