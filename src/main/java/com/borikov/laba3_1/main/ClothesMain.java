package com.borikov.laba3_1.main;

import com.borikov.laba3_1.entity.Blouse;
import com.borikov.laba3_1.entity.Jacket;
import com.borikov.laba3_1.entity.Pants;
import com.borikov.laba3_1.print.InfoWriter;

public class ClothesMain {
    public static void main(String[] args) {
        Jacket jacket = new Jacket("Belarus", 100, "Home");
        jacket.setSeasonality("Spring");
        jacket.setHood(true);
        Blouse blouse = new Blouse();
        blouse.setManufacturer("Russia");
        blouse.setPrice(50);
        blouse.setStyle("Away");
        blouse.setSleeveLength(60);
        blouse.setPercentageOfWool(58);
        Pants pants = new Pants("Poland", 200, "Everyday", 20);
        InfoWriter infoWriter = new InfoWriter();
        infoWriter.printBlouseInfo(blouse);
        infoWriter.printJacketInfo(jacket);
        infoWriter.printPantsInfo(pants);
    }
}
