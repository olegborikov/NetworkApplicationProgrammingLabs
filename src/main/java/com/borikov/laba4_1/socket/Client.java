package com.borikov.laba4_1.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8081);
             BufferedReader input = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             BufferedWriter output = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));) {
            System.out.println("Client connected");
            Scanner scanner = new Scanner(System.in);
            String inputWord;
            do {
                System.out.print("Enter the word, which you want " +
                        "to find in text(quit to exit): ");
                inputWord = scanner.nextLine();
                output.write(inputWord + "\n");
                output.flush();
                String answer = input.readLine();
                System.out.println("Answer is \"" + answer + "\"");
            } while (!inputWord.equals("quit"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
