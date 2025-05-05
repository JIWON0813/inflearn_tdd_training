package sample.cafekiosk.unit;

import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;

public class CafeKioskRunner {

    public static void main(String[] args) {
        CafeKiosk cafeKiosk = new CafeKiosk();
//        cafeKiosk.add(new Americano());
//        System.out.println("add ame");
//        cafeKiosk.add(new Latte());
//        System.out.println("add latter");

        int totalPrice = cafeKiosk.calculate();
        System.out.println("total price : " + totalPrice);
    }
}
