package dev.extframework.test.profile;

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
    }
}
