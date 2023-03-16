package org.example;

import lombok.RequiredArgsConstructor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@RequiredArgsConstructor
public class SocketManager {

    private final IService service;

    public void runListener(int port) {
        try (
                ServerSocket server = new ServerSocket(port);
        ) {
            System.out.println("Server is running on port " + port);
            try (Socket clientSocket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            ) {
                service.init(in, out);
                service.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Server is closed!");
        }
    }

}
