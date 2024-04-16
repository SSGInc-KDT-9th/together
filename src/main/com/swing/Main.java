package main.com.swing;

import javax.swing.*;
import java.awt.EventQueue;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // updateorderFrame을 직접 실행하고 매개변수를 전달
                    updateorderFrame frame = new updateorderFrame("Icecream");
                    frame.setSize(508, 500); // 원하는 크기로 설정
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}