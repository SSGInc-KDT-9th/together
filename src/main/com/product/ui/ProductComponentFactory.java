package main.com.product.ui;

import javax.swing.*;
import java.awt.*;

public class ProductComponentFactory {
    private Dimension lblSize = new Dimension(80, 30);
    private Dimension btnSize  = new Dimension(100, 25);
    int tfSize = 10;

    public JLabel getLabel(String labelText){
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(lblSize);
        return label;
    }

    public JButton getButton(String buttonText){
        JButton button = new JButton(buttonText);
        button.setPreferredSize(btnSize);
        return button;
    }

    public JTextField getTextField(){
        return new JTextField(tfSize);
    }
}
