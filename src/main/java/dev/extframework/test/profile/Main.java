package dev.extframework.test.profile;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append("Program arguments:\n");
        for (String arg : args) {
            builder.append("  ");
            builder.append(arg);
            builder.append("\n");
        }

        builder.append("Program name: '");
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        builder.append(pid);
        builder.append("'");

        // create a server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // set a handler to respond to GET requests on "/"
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("GET".equals(exchange.getRequestMethod())) {
                    String responseText = builder.toString(); // modify this variable to specify your plain text
                    exchange.sendResponseHeaders(200, responseText.getBytes().length);
                    OutputStream outputStream = exchange.getResponseBody();
                    outputStream.write(responseText.getBytes());
                    outputStream.close();
                } else {
                    exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
                }
            }
        });
        server.start();

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
