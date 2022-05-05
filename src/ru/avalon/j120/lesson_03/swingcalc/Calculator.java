package ru.avalon.j120.lesson_03.swingcalc;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    JPanel centralPanel;

    public Calculator() {
        init();
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        Container cp = getContentPane();
        JTextArea textArea = new JTextArea();
        GridLayout gridLayout = new GridLayout(5, 4);
//        JPanel jPanel = new JPanel(gridLayout);

        centralPanel = new JPanel(gridLayout);
        cp.add(centralPanel, BorderLayout.CENTER);
        buttons();
        cp.add(textArea, BorderLayout.NORTH);

    }

    private void buttons() {
        JButton[] buttons = new JButton[19];

        buttons[0] =  new JButton("C");
        buttons[1] =  new JButton("/");
        buttons[2] =  new JButton("*");
        buttons[3] =  new JButton("<-");
        buttons[4] =  new JButton("7");
        buttons[5] =  new JButton("8");
        buttons[6] =  new JButton("9");
        buttons[7] =  new JButton("-");
        buttons[8] =  new JButton("4");
        buttons[9] =  new JButton("5");
        buttons[10] = new JButton("6");
        buttons[11] = new JButton("+");
        buttons[12] = new JButton("1");
        buttons[13] = new JButton("2");
        buttons[14] = new JButton("3");
        buttons[15] = new JButton("=");
        buttons[16] = new JButton("%");
        buttons[17] = new JButton("0");
        buttons[18] = new JButton(",");

        for (JButton jb : buttons) {
            centralPanel.add(jb);
        }
    }


}
