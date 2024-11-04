package lab2.task2;

import lab2.task2.Coffee.Intensity;

public class Main {
    public static void main(String[] args) {

        Coffee coffee = new Coffee(Intensity.STRONG);
        coffee.printDetails();
        System.out.println("\n");

        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 100);
        cappuccino.printDetails();
        System.out.println("\n");

        PumpkinSpiceLatte psl = new PumpkinSpiceLatte(Intensity.LIGHT, 100, 30);
        psl.printDetails();
        System.out.println("\n");
    }
}