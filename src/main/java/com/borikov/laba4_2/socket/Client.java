package com.borikov.laba4_2.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y: ");
        double y = scanner.nextDouble();
        System.out.print("Enter z: ");
        double z = scanner.nextDouble();
        String info = x + " " + y + " " + z;
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] receiveInfo = new byte[512];
            byte[] sendInfo = info.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendInfo, sendInfo.length,
                    InetAddress.getByName("127.0.0.1"), 8081);
            datagramSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveInfo, receiveInfo.length);
            datagramSocket.receive(receivePacket);
            String result = new String(receivePacket.getData());
            System.out.println("Result is: " + result);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
