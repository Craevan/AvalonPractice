package ru.avalon.j120.lesson_04;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame {

    File file;
    JMenuBar bar;
    JMenu menuFile;
    JMenuItem open;
    JMenuItem save;
    JTextArea textArea;


    public void start() {
        setSize(640, 480);
        setTitle("MyFavoriteText Editor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addJMenuBar();
        textArea = new JTextArea();
        JButton clear = new JButton("Clear");
        add(clear, BorderLayout.SOUTH);
        clear.addActionListener(e -> textArea.setText(null));
        add(textArea);
        setVisible(true);
    }

    private void addJMenuBar() {
        bar = new JMenuBar();
        setJMenuBar(bar);

        menuFile = new JMenu("File");
        bar.add(menuFile);

        addOpenFileOption();
        addSaveFileOption();
        menuFile = new JMenu("Help");
        bar.add(menuFile);
    }

    private void addOpenFileOption() {
        open = new JMenuItem("Open");
        open.addActionListener(e -> {
                    JFileChooser chooser = new JFileChooser("C:\\Users\\alesiv\\Docs\\J_DEV");
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int i = chooser.showOpenDialog(this);
                    if (i == JFileChooser.APPROVE_OPTION) {
                        file = chooser.getSelectedFile();
                        readFile();
                    }
                }
        );

        menuFile.add(open);
    }

    private void addSaveFileOption() {
        save = new JMenuItem("Save");
        save.addActionListener(e -> writeFile());
        menuFile.add(save);
    }

    private void readFile() {
        if (file != null && file.exists() && file.canRead()) {
            StringBuilder sb = new StringBuilder();
            try (FileReader fReader = new FileReader(file)) {
                char[] cBuff = new char[1024];
                int len = 0;
                while ((len = fReader.read(cBuff)) > -1) {
                    sb.append(cBuff, 0, len);
                }
                textArea.setText(sb.toString());
            } catch (IOException ioe) {

            }
        }
    }

    private void writeFile() {
        if (file == null) {
            JFileChooser chooser = new JFileChooser("C:\\Users\\alesiv\\Docs\\J_DEV");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int i = chooser.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
                file = chooser.getSelectedFile();
        }

        if (file != null && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {

            }
        }

        if (file != null && file.exists()) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(textArea.getText());
            } catch (IOException ioException) {

            }
        }
    }

}
