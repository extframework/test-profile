package dev.extframework.test.profile;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) {
        throw  new RuntimeException("This is an exception to test if the game started.");

//        JFrame frame = new JFrame("Simple GUI");
//        JTextArea textArea = new JTextArea(20, 30);
//
//        StringBuilder texts = new StringBuilder();
//        for (String arg : args) {
//            texts.append("  ");
//            texts.append(arg);
//            texts.append("\n");
//        }
//
//        String pid = ManagementFactory.getRuntimeMXBean().getName();
//
//        textArea.append("Process ID: " + pid + "\n");
//        textArea.append("Program arguments:\n");
//        textArea.append(texts.toString());
//
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//        frame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
    }
}
