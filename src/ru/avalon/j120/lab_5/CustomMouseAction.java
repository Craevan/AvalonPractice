package ru.avalon.j120.lab_5;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseAction extends MouseAdapter {

    private final MainFrame frame;

    public CustomMouseAction(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int clickCount = e.getClickCount();
        if (clickCount == 1) {

        }
        else {
            // тут должна быть проверка instanceof
            JTree tree = (JTree) e.getSource();
            String key = tree.getSelectionPath().getLastPathComponent().toString();
            frame.fileDir = frame.fileMap.get(key);
            if (frame.fileDir != null && frame.fileDir.exists() && frame.fileDir.isDirectory()) {
                frame.addTree();
            }
        }
    }

}
