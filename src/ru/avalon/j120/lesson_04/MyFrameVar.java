package ru.avalon.j120.lesson_04;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFrameVar extends JFrame {

    JMenuBar bar;
    JMenu menu;
    Map<Integer, List<String>> elements = new HashMap<>();

    {
        elements.put(0, Arrays.asList("Open", "Save", "Save As", "Exit"));
        elements.put(1, Arrays.asList("Cancel", "Put", "Copy"));
        elements.put(2, Arrays.asList("FullScreen", "Theme", "Scale"));
        elements.put(3, Arrays.asList("Help", "Donate"));
    }

    public void start() {
        setSize(640, 480);
        setTitle("MyFavoriteText Editor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addJMenuBar();

        setVisible(true);
    }

    private void addJMenuBar() {
        bar = new JMenuBar();
        setJMenuBar(bar);
        addJMenu(Arrays.asList("File", "Edit", "View", "About"));
        addJMenuItem(elements);
    }

    private void addJMenu(List<String> menuElements) {
        for (String element : menuElements) {
            menu = new JMenu(element);
            bar.add(menu);
        }
    }

    private void addJMenuItem(Map<Integer, List<String>> menuElements) {

        for (int i = 0; i < bar.getMenuCount(); i++) {
           menu = getJMenuBar().getMenu(i);
           for (String element : menuElements.get(i)) {
                menu.add(element);
           }
        }

    }

}
