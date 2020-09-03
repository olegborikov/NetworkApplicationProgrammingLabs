package com.borikov.laba4_2.socket;

import com.borikov.laba4_2.service.ArithmeticService;
import com.borikov.laba4_2.writer.CustomFileWriter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(8081)) {
            System.out.println("Server started");
            byte[] receiveInfo = new byte[512];
            DatagramPacket receivePacket = new DatagramPacket(receiveInfo, receiveInfo.length);
            datagramSocket.receive(receivePacket);
            String info = new String(receivePacket.getData());
            System.out.println(info);
            String[] numbers = info.split(" ");
            ArithmeticService arithmeticService = new ArithmeticService();
            double result = arithmeticService.calculateExpression(
                    Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]),
                    Double.parseDouble(numbers[2]));
            CustomFileWriter customFileWriter = new CustomFileWriter();
            customFileWriter.writeInFile(Double.parseDouble(numbers[0]),
                    Double.parseDouble(numbers[1]), Double.parseDouble(numbers[2]), result);
            byte[] answer = String.valueOf(result).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(answer, answer.length,
                    receivePacket.getAddress(), receivePacket.getPort());
            datagramSocket.send(sendPacket);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
