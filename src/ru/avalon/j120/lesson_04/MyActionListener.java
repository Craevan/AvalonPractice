package ru.avalon.j120.lesson_04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private JFrame frame;

    public MyActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JMenuItem menuItem;
        if (actionEvent.getSource() instanceof JMenuItem) {
            menuItem = (JMenuItem) actionEvent.getSource();
            System.out.println("Pressed item " + menuItem.getText());
        }
    }

}
