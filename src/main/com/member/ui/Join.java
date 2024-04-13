package main.com.member.ui;

import main.com.member.domain.Member;
import main.com.member.domain.MemberRole;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Join extends JDialog{
    private Login owner;
    private JLabel title;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel retryLabel;
    private JTextField tfName;
    private JTextField tfId;
    private JPasswordField tfPassword;
    private JPasswordField tfRePassword;
    private JButton quitButton;
    private JButton joinButton;
    private JRadioButton adminRButton;
    private JRadioButton empRButton;
    public Join(Login owner){
        super(owner,"Join",true);
        this.owner = owner;

        setComponent();
        setDisplay();
        addListner();
        showFrame();
    }

    private void setComponent(){
        int tfSize = 10;
        Dimension lblSize = new Dimension(80, 35);
        Dimension btnSize = new Dimension(100 ,25);
        title = new JLabel("회원 가입");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        nameLabel = new JLabel("이름",JLabel.LEFT);
        nameLabel.setPreferredSize(lblSize);

        idLabel = new JLabel("ID",JLabel.LEFT);
        idLabel.setPreferredSize(lblSize);

        passwordLabel = new JLabel("PASSWORD",JLabel.LEFT);
        passwordLabel.setPreferredSize(lblSize);

        retryLabel = new JLabel("비밀번호 재입력",JLabel.LEFT);
        retryLabel.setPreferredSize(lblSize);

        tfName = new JTextField(tfSize);
        tfId = new JTextField(tfSize);
        tfPassword = new JPasswordField(tfSize);
        tfRePassword = new JPasswordField(tfSize);

        adminRButton = new JRadioButton("Admin", true);
        empRButton = new JRadioButton("Employee");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(adminRButton);
        typeGroup.add(empRButton);

        joinButton = new JButton("Join");
        joinButton.setPreferredSize(btnSize);
        quitButton = new JButton("Cancel");
        quitButton.setPreferredSize(btnSize);
    }

    private void setDisplay(){
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);
        JPanel joinMain = new JPanel(new BorderLayout());

        JPanel pnlMNorth = new JPanel(flowLeft);
        joinMain.add(title);

        JPanel pnlMCenter = new JPanel(new GridLayout(0, 1));
        JPanel pnlName = new JPanel(flowLeft);
        pnlName.add(nameLabel);
        pnlName.add(tfName);

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(idLabel);
        pnlId.add(tfId);


        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(passwordLabel);
        pnlPw.add(tfPassword);

        JPanel pnlRe = new JPanel(flowLeft);
        pnlRe.add(retryLabel);
        pnlRe.add(tfRePassword);

        pnlMCenter.add(pnlName);
        pnlMCenter.add(pnlId);
        pnlMCenter.add(pnlPw);
        pnlMCenter.add(pnlRe);

        // pnlMSouth(rbtnMale / rbtnFemale)
        JPanel pnlMSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlMSouth.add(adminRButton);
        pnlMSouth.add(empRButton);
        pnlMSouth.setBorder(new TitledBorder("직급"));

        // pnlMain
        joinMain.add(pnlMNorth, BorderLayout.NORTH);
        joinMain.add(pnlMCenter, BorderLayout.CENTER);
        joinMain.add(pnlMSouth, BorderLayout.SOUTH);

        // pnlSouth(btnJoin / btnCancel)
        JPanel pnlSouth = new JPanel();
        pnlSouth.add(joinButton);
        pnlSouth.add(quitButton);

        // 화면 테두리의 간격을 주기 위해 설정 (insets 사용 가능)
        joinMain.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        add(joinMain, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }


    private void addListner(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
                owner.setVisible(true);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                owner.setVisible(true);
            }
        });

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = tfId.getText();
                String passWord = new String(tfPassword.getPassword());
                //String
                Member member = new Member();
            }
        });
    }

    private MemberRole getRole(){
        if(adminRButton.isSelected()){
            return MemberRole.ADMIN;
        }
        else{
            return MemberRole.EMPLOYEE;
        }
    }
    private void showFrame() {
        pack();
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
