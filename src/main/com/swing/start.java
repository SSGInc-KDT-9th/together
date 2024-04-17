package main.com.swing;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.com.config.Session;
import main.com.member.Login;
import main.com.order.dao.OrderDAO;
import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;
import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;
import main.com.release.service.ReleaseService;
import main.com.release.service.ReleaseServiceImpl;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;



public class start extends JFrame {
	private static JFrame frame;
	
	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	           public void run() {
	              try {
	                 start frame = new start();
//	                 frame.setSize(1280, 720);
	                 frame.setVisible(true);
	              } catch (Exception e) {
	                 e.printStackTrace();
	              }
	           }
	        });
	 }
	 
	 JButton start;
	 JLabel lblNewLabel;

	 
	public start() {
//		  start frame = new start();
//          frame.setSize(1280, 720);
//          frame.setVisible(true);
		setSize(1280, 720);
		getContentPane().setBackground(new Color(245, 245, 220));
		getContentPane().setLayout(null);
		
		start = new JButton("Start");
		start.setForeground(Color.BLACK); // 전경색을 검정으로 설정
		start.setFont(new Font("Arial", Font.BOLD, 25)); 
		start.setBackground(new Color(139, 69, 19)); // 배경색을 갈색으로 설정 (RGB 값은 갈색에 가까운 값입니다)
		start.setBounds(502, 493, 222, 82);
		getContentPane().add(start);
		
		lblNewLabel = new JLabel("물류관리시스템");
		lblNewLabel.setForeground(Color.BLACK); 
		lblNewLabel.setFont(new Font("고딕", Font.BOLD, 35)); // 글꼴을 Arial, 굵게, 크기 20으로 설정
		lblNewLabel.setBounds(491, 92, 493, 109);
		getContentPane().add(lblNewLabel);
		
		
		
		
		// 이미지 아이콘을 생성하고 이미지를 로드합니다.
		// 라벨 생성
        JLabel imgLabel = new JLabel();
        
        // 아이콘 생성
        // 생성자 인수 → 현재클래스명.class.getResource("/패키지명/이미지폴더명/이미지파일명")
        // ※ 이미지파일명은 반드시 확장자까지 같이 적어줄 것
        ImageIcon icon = new ImageIcon(
            start.class.getResource("/main/com/swing/together.png")
        );
        
        // 라벨에 아이콘(이미지) 설정
        imgLabel.setIcon(icon);
        
        // 라벨 설정(크기, 정렬...)
        imgLabel.setBounds(491, 200, 251, 246);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
        //프레임에 컴포넌트 추가
    	getContentPane().add(imgLabel);
    	
        // 프레임 보이기 지정
        setVisible(true);
        frame = this;
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    new Login();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
				
			}
		});
		
	}
	 public static void closeFrame() {
	        // 클래스 변수에 할당된 프레임을 닫음
		 	
	        frame.dispose();
	    }
    }	
