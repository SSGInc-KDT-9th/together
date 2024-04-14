package main.com.member.ui;

import main.com.config.AppConfig;
import main.com.member.domain.Member;
import main.com.member.domain.MemberRole;
import main.com.member.service.MemberService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Join extends JDialog{
    private final MemberService memberService;
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
    private JRadioButton commonButton;
    public Join(Login owner){
        super(owner,"Join",true);
        this.owner = owner;

        AppConfig appConfig =new AppConfig();
        memberService = appConfig.memberService();

        setComponent();
        setDisplay();
        addListner();
        showFrame();
    }

    private void setComponent(){
        int tfSize = 15;
        Dimension lblSize = new Dimension(100, 35);
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

        adminRButton = new JRadioButton("ADMIN", true);
        commonButton = new JRadioButton("COMMON");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(adminRButton);
        typeGroup.add(commonButton);

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
        pnlMSouth.add(commonButton);
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
            public void actionPerformed(ActionEvent ae) {
                String id = tfId.getText();
                String memberName = tfName.getText();
                String password = new String(tfPassword.getPassword());
                String retry = new String(tfRePassword.getPassword());
                if(isBlank()) {
                    JOptionPane.showMessageDialog(
                            Join.this,
                            "모든 정보를 입력해주세요."
                    );
                    // 모두 입력했을 때
                } else {
                    // Id 중복일 때
                    if(!memberService.validMemberId(id)) {
                        JOptionPane.showMessageDialog(
                                Join.this,
                                "이미 존재하는 Id입니다."
                        );
                        tfId.requestFocus();
                        // Pw와 Re가 일치하지 않았을 때
                    } else if(!String.valueOf(password).equals(retry)) {
                        JOptionPane.showMessageDialog(
                                Join.this,
                                "Password와 Retry가 일치하지 않습니다."
                        );
                        tfPassword.requestFocus();
                    } else {
                        MemberRole role = getRole();
                        Member member= new Member(memberName,id,password,role);
                        memberService.join(member);
                        JOptionPane.showMessageDialog(
                                Join.this,
                                "회원가입을 완료했습니다!"
                        );
                        dispose();
                        owner.setVisible(true);
                    }
                }
            }
        });
    }
    private void showFrame() {
        pack();
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private boolean isBlank() {
        boolean result = false;
        if(tfId.getText().isEmpty()) {
            tfId.requestFocus();
            return true;
        }
        if(String.valueOf(tfPassword.getPassword()).isEmpty()) {
            tfPassword.requestFocus();
            return true;
        }
        if(String.valueOf(tfRePassword.getPassword()).isEmpty()) {
            tfRePassword.requestFocus();
            return true;
        }
        if(tfName.getText().isEmpty()) {
            tfName.requestFocus();
            return true;
        }
        return result;
    }

    private MemberRole getRole() {
        if(adminRButton.isSelected()) {
            return MemberRole.ADMIN;
        }
        return MemberRole.COMMON;
    }

}
