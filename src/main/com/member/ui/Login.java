package main.com.member.ui;

import main.com.config.AppConfig;
import main.com.config.Session;
import main.com.member.service.MemberService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame{
    private final MemberService memberService;
    private JPanel contentPanel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField inputId;
    private JPasswordField inputPassword;
    private JButton loginButton;
    private JButton joinButton;

    public Login(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();;
        initComponent();
        setDisplay();
        addListener();
        setTitle("Together");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }


    private void initComponent(){
        Dimension lblSize = new Dimension(80, 30);
        int tfSize = 10;
        Dimension btnSize  = new Dimension(100, 25);
        contentPanel = new JPanel();
        idLabel = new JLabel("ID : ");
        passwordLabel= new JLabel("Password : ");
        idLabel.setPreferredSize(lblSize);
        passwordLabel.setPreferredSize(lblSize);

        inputId = new JTextField(tfSize);
        inputPassword = new JPasswordField(tfSize);

        loginButton = new JButton("Login");
        joinButton = new JButton("Join");

        loginButton.setPreferredSize(btnSize);
        joinButton.setPreferredSize(btnSize);
    }
    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlNorth(pnlId, pnlPw)
        JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(idLabel);
        pnlId.add(inputId);

        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(passwordLabel);
        pnlPw.add(inputPassword);

        pnlNorth.add(pnlId);
        pnlNorth.add(pnlPw);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(loginButton);
        pnlSouth.add(joinButton);

        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);

    }

    private void addListener(){
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Join(Login.this);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = inputId.getText();
                String password = new String(inputPassword.getPassword());
                boolean login = memberService.login(id, password);
                if(login) {
                    Session.setMember(memberService.findMember(id));
                    System.out.println(id);
                }
                else{
                    JOptionPane.showMessageDialog(null, "아이디 또는 패스워드를 확인해주세요", "ID Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int choice = JOptionPane.showConfirmDialog(
                        Login.this,
                        "프로그램을 종료하시겠습니까?",
                        "종료",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}