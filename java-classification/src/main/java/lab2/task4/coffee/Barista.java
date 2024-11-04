package lab2.task4.coffee;

import lab2.task4.coffee.drinks.Coffee.Intensity;
import lab2.task4.coffee.drinks.Cappuccino;
import lab2.task4.coffee.drinks.Americano;
import lab2.task4.coffee.drinks.PumpkinSpiceLatte;
import lab2.task4.coffee.drinks.SyrupCappuccino;
import lab2.task4.coffee.drinks.SyrupCappuccino.SyrupType;

import java.util.ArrayList;
import java.util.List;

public class Barista {
    // list to store orders
    private final List<String> orders = new ArrayList<>();
    
    // method to take order
    public void takeOrder(String coffeeType, Intensity intensity) {
        orders.add(coffeeType);
        System.out.println("Order taken: " + coffeeType + " with " + intensity + " intensity");
    }
    
    // make and serve coffee
    public void serveCoffee() {
        for (String order : orders) {
            System.out.println("\nPreparing " + order + " ");
            switch (order) {
                case "Americano":
                    Americano americano = new Americano(Intensity.NORMAL, 100);
                    americano.makeAmericano();
                    americano.printDetails();
                    break;
                    
                case "Cappuccino":
                    Cappuccino cappuccino = new Cappuccino(Intensity.STRONG, 150);
                    cappuccino.makeCappuccino();
                    cappuccino.printDetails();
                    break;
                    
                case "Pumpkin Spice Latte":
                    PumpkinSpiceLatte psl = new PumpkinSpiceLatte(Intensity.LIGHT, 200, 30);
                    psl.makePumpkinSpiceLatte();
                    psl.printDetails();
                    break;
                    
                case "Syrup Cappuccino":
                    SyrupCappuccino syrupCap = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.VANILLA);
                    syrupCap.makeSyrupCappuccino();
                    syrupCap.printDetails();
                    break;
            }
            System.out.println("Order completed\n");
        }
        // clear orders after serving
        orders.clear();
    }
}