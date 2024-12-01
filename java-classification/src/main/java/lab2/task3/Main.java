package lab2.task3;

import lab2.task3.Coffee.Intensity;

public class Main {
    public static void main(String[] args) {

        System.out.println("Making Pumpkin Spice Latte");
        PumpkinSpiceLatte psl = new PumpkinSpiceLatte(Intensity.STRONG, 150, 30);
        psl.makePumpkinSpiceLatte();
        System.out.println("\nFinal drink details:");
        psl.printDetails();
    }
}