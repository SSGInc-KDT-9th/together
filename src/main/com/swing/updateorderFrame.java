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
import main.com.order.dao.OrderDAO;
import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;
import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;
import main.com.release.service.ReleaseService;
import main.com.release.service.ReleaseServiceImpl;

public class updateorderFrame extends JFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private String icecream;
    private int ordid;

    public updateorderFrame(String icecream, int ordid) {
        this.icecream = icecream;
        this.ordid = ordid;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 508, 500);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("상품명");
        lblNewLabel.setBounds(84, 55, 91, 44);
        lblNewLabel.setFont(new Font("고딕", Font.BOLD, 17));
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("수량");
        lblNewLabel_1.setBounds(84, 180, 91, 36);
        lblNewLabel_1.setFont(new Font("고딕", Font.BOLD, 17));
        getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("확인");
        btnNewButton.setBounds(239, 356, 91, 40);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("취소");
        btnNewButton_1.setBounds(370, 356, 91, 40);
        getContentPane().add(btnNewButton_1);

//        textField = new JTextField();
//        textField.setBounds(228, 10, 123, 35);
//        getContentPane().add(textField);
//        textField.setColumns(10);


        textField_1 = new JTextField();
        textField_1.setBounds(228, 185, 123, 31);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        

        lblNewLabel_2 = new JLabel(icecream);
        lblNewLabel_2.setBounds(228, 62, 123, 35);
        lblNewLabel_2.setFont(new Font("고딕", Font.BOLD, 17));
        contentPane.add(lblNewLabel_2);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = lblNewLabel_2.getText(); // 상품명

                // 상품명으로 productid 찾기
                OrderService orderService = new OrderServiceImpl();
                int productId = orderService.findProductId(productName);
                String cnt = textField_1.getText();
                int itemcnt = Integer.parseInt(cnt);
                // itemcnt, productId ,orderid넘겨주기
//                int orderid = orderService.orderid(productId);
                OrderDTO dto = new OrderDTO();
                dto.setOrder_cnt(itemcnt);
                dto.setProduct_id(productId);
                dto.setId(ordid);
                // 주문 업데이트
                OrderService rs = new OrderServiceImpl();
                rs.setDao(new OrderDAO());
                rs.updateorder(dto);
                // 변경완료되었습니다. 알림창
                JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        // 취소 버튼
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 창 닫기
                dispose();
            }
        });
    }
}
