package com.borikov.laba2_2.main;

import com.borikov.laba2_2.entity.impl.*;

public class OrderMain {
    public static void main(String[] args) {
        Body body = new Body("body", "zalman", 50, 100, "aluminium", "full tower");
        GraphicsCard graphicsCard = new GraphicsCard();
        graphicsCard.setModel("gigabyte");
        graphicsCard.setCost(190);
        graphicsCard.setPrice(250);
        graphicsCard.setVideoMemoryType("DDR4");
        graphicsCard.setVideoMemoryBus("160 bit");
        HardDisk hardDisk = new HardDisk("hard disk", "toshiba", 100, 150, 500);
        MotherBoard motherBoard = new MotherBoard("mother board", "gigabyte", 200, 230, "LGA1151", "DDR4");
        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setModel("aeroCool");
        powerSupply.setCost(40);
        powerSupply.setPrice(70);
        powerSupply.setPower(500);
        Processor processor = new Processor();
        graphicsCard.setModel("intel");
        processor.setCost(130);
        processor.setPrice(200);
        processor.setSocket("DDR4");
        processor.setActFrequency(4.3);
        RandomAccessMemory randomAccessMemory = new RandomAccessMemory("random access memory", "hyperX", 100, 160, 32, "DDR4");
        Order order = new Order();
        order.addComponent(body);
        order.addComponent(graphicsCard);
        order.addComponent(hardDisk);
        order.addComponent(motherBoard);
        order.addComponent(powerSupply);
        order.addComponent(processor);
        order.addComponent(randomAccessMemory);
        order.printInfo();
        order.countPrice();
        order.printInfo();
        System.out.println(order.toString());
    }
}
