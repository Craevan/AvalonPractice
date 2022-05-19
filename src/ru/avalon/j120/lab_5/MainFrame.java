package ru.avalon.j120.lab_5;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainFrame extends JFrame {

    File fileDir;
    JTextArea textArea = new JTextArea();
    JSplitPane pane;
    JTree tree;
    Map<String, File> fileMap = new HashMap<>();

    public void init() {
        setTitle("FileTreeViewer");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        addMenu();
        addSplitPane();
        setLocation(500, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addMenu() {
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open dir");
        bar.add(menu);
        menu.add(menuItem);
        menuItem.addActionListener(e -> {
            chooseDir();
            if (fileDir != null && fileDir.exists()) {
                addTree();
            }
        });
    }

    private void chooseDir() {
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\alesiv\\Docs\\");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userAction = fileChooser.showOpenDialog(this);
        if (userAction == JFileChooser.APPROVE_OPTION) {
            fileDir = fileChooser.getSelectedFile();
        }
    }

    private void addSplitPane() {
        pane = new JSplitPane();
        tree = new JTree();
        add(pane);
        pane.setLeftComponent(tree);
        fileDir = new File("C:\\Users\\alesiv\\Docs\\");
        addTree();
        pane.setRightComponent(new JScrollPane(textArea));
    }

    protected void addTree() {
        tree = new JTree(getLimitedTreeNodes(fileDir));
        pane.setLeftComponent(new JScrollPane(tree));
        tree.addMouseListener(new CustomMouseAction(this));
    }

//    private MutableTreeNode getTreeNode(File file) {
//        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
//        if (file.isDirectory()) {
//            for (File f : file.listFiles()) {
//                node.add(getTreeNode(f));
//            }
//        }
//        return node;
//    }

    private MutableTreeNode getLimitedTreeNodes(File file) {
        DefaultMutableTreeNode parent = new DefaultMutableTreeNode("..");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
        parent.add(node);
        fileMap.put("..", file.getParentFile());
        fileMap.put(file.getName(), file);
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(f);
                node.add(tmp);
                if (f.isDirectory()) {
                    tmp.add(new DefaultMutableTreeNode());
                }
                fileMap.put(file.getName(), file);
            }
        }
        return node;
    }

}
