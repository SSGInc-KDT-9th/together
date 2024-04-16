package main.com;

import main.com.member.Login;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
