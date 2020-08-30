package com.borikov.laba4_1.socket;

import com.borikov.laba4_1.service.TextService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(8081);
             Socket socket = serverSocket.accept();
             BufferedReader input = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter output = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()))) {
            System.out.println("Client connected");
            TextService textService = new TextService();
            String inputWord;
            do {
                inputWord = input.readLine();
                System.out.println("Received word is \"" + inputWord + "\"");
                String answer = textService.findSentencesByWord(inputWord);
                System.out.println("Answer is \"" + answer + "\"");
                output.write(answer + "\n");
                output.flush();
            } while (!inputWord.equals("quit"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
