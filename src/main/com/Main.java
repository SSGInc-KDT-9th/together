package main.com;

import main.com.member.Login;
import main.com.swing.start;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
