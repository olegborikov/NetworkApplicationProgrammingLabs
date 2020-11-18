package com.borikov.laba6.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class WinterWindow extends JFrame {
    private int cloudWidth = 1000;
    private int cloudHeight = 150;
    private int snowBankWidth = 1000;
    private int snowBankHeight = 200;
    private int snowBankY = 400;
    private int snowflakeX = 200;
    private int snowflakeY = 50;
    private int snowflakeX1 = 500;
    private int snowflakeY1 = 505;
    private int snowflakeX2 = 550;
    private int snowflakeY2 = 505;
    private int snowflakeX3 = 640;
    private int snowflakeY3 = 415;
    private int snowflakeX4 = 752;
    private int snowflakeY4 = 420;
    private int snowflakeX5 = 670;
    private int snowflakeY5 = 385;
    private int snowflakeX6 = 480;
    private int snowflakeY6 = 5;
    private Image background;
    private Image snowflake;
    private Image snowdrift;
    private Image cloud;
    private Thread snowThread;
    private Thread snowFlakeThread;

    private static final ReentrantLock lock = new ReentrantLock();

    public WinterWindow() {
        snowThread = new Thread(new SnowThread());
        snowFlakeThread = new Thread(new SnowFlakeThread());
        setParameters();
        addComponents();
    }

    public void setParameters() {
        setTitle("Winter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    background = ImageIO.read(new File("input/background.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(background, 0, 0, null);
            }
        });
    }

    public void addComponents() {
        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(400, 50));
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(actionEvent -> {
            if (snowThread.isAlive() && snowFlakeThread.isAlive()) {
                if (lock.isLocked()) {
                    lock.unlock();
                }
            } else {
                if (!snowThread.getState().equals(Thread.State.TERMINATED)
                        && !snowFlakeThread.getState().equals(Thread.State.TERMINATED)) {
                    snowThread.start();
                    snowFlakeThread.start();
                }
            }
        });
        JButton stopButton = new JButton("Stop");
        stopButton.setPreferredSize(new Dimension(400, 50));
        stopButton.setBackground(Color.white);
        stopButton.setForeground(Color.BLACK);
        stopButton.addActionListener(actionEvent -> {
            if (snowThread.isAlive() && snowFlakeThread.isAlive()) {
                if (!lock.isLocked()) {
                    lock.lock();
                }
            }
        });
        add(startButton);
        add(stopButton);
        add(new JPanel() {
            {
                setOpaque(false);
                setPreferredSize(new Dimension(1000, 600));
                try {
                    cloud = ImageIO.read(new File("input/cloud.png"));
                    snowdrift = ImageIO.read(new File("input/snowdrift.png"));
                    snowflake = ImageIO.read(new File("input/snowflake.png"));
                } catch (IOException e) {
                    System.err.println("Error while reading images");
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.drawImage(cloud, 0, 0, cloudWidth, cloudHeight, this);
                graphics2D.drawImage(snowdrift, 0, snowBankY, snowBankWidth, snowBankHeight, this);
                graphics2D.drawImage(snowflake, snowflakeX, snowflakeY, 25, 25, this);
                graphics2D.drawImage(snowflake, snowflakeX1, snowflakeY1, 55, 55, this);
                graphics2D.drawImage(snowflake, snowflakeX2, snowflakeY2, 35, 35, this);
                graphics2D.drawImage(snowflake, snowflakeX3, snowflakeY3, 45, 45, this);
                graphics2D.drawImage(snowflake, snowflakeX4, snowflakeY4, 35, 35, this);
                graphics2D.drawImage(snowflake, snowflakeX5, snowflakeY5, 45, 45, this);
                graphics2D.drawImage(snowflake, snowflakeX6, snowflakeY6, 25, 25, this);
            }
        });
    }

    private class SnowThread implements Runnable {
        @Override
        public void run() {
            while (cloudHeight > 0) {
                if (!lock.isLocked()) {
                    cloudHeight = cloudHeight - 2;
                    snowBankHeight = snowBankHeight + 4;
                    snowBankY = snowBankY - 4;
                    repaint();
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted");
                    }
                }
            }
        }
    }

    private class SnowFlakeThread implements Runnable {
        @Override
        public void run() {
            while (cloudHeight > 0) {
                if (!lock.isLocked()) {
                    snowflakeX = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX1 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY1 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX2 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY2 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX3 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY3 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX4 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY4 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX5 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY5 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    snowflakeX6 = ThreadLocalRandom.current().nextInt(0, cloudWidth + 1);
                    snowflakeY6 = ThreadLocalRandom.current().nextInt(cloudHeight, snowBankY + 1);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted");
                    }
                }
            }
        }
    }
}
