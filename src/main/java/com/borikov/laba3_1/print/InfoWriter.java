package com.borikov.laba3_1.print;

import com.borikov.laba3_1.entity.Blouse;
import com.borikov.laba3_1.entity.Clothes;
import com.borikov.laba3_1.entity.Jacket;
import com.borikov.laba3_1.entity.Pants;

public class InfoWriter {
    public void printClothesInfo(Clothes clothes) {
        System.out.println("Manufacturer: " + clothes.getManufacturer());
        System.out.println("Price: " + clothes.getPrice());
        System.out.println("Style: " + clothes.getStyle());
        System.out.println("Brand: " + clothes.brand());
    }

    public void printBlouseInfo(Blouse blouse) {
        System.out.println("Blouse");
        printClothesInfo(blouse);
        System.out.println("Sleeve length: " + blouse.getSleeveLength());
        System.out.println("Percentage of wool: " + blouse.getPercentageOfWool());
    }

    public void printJacketInfo(Jacket jacket) {
        System.out.println("Jacket");
        printClothesInfo(jacket);
        System.out.println("Seasonality: " + jacket.getSeasonality());
        System.out.println("Hood: " + jacket.isHood());
    }

    public void printPantsInfo(Pants pants) {
        System.out.println("Pants");
        printClothesInfo(pants);
        System.out.println("Flared: " + pants.getFlared());
    }
}
