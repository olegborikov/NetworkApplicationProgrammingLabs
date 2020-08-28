package com.borikov.laba3_2.main;

import com.borikov.laba3_2.entity.*;

public class ClothesMain {
    public static void main(String[] args) {
        Jacket windBreaker = new WindBreaker("Belarus", 100, "Home", "Spring", true);
        Jacket downJacket = new DownJacket("Ukraine", 150, "Away", "Winter", false);
        Blouse blouse = new Blouse("Russia", 50, "Away", 60, 58);
        Pants pants = new Pants("Poland", 200, "Everyday", 20);
        windBreaker.printInfo();
        downJacket.printInfo();
        blouse.printInfo();
        pants.printInfo();
    }
}
