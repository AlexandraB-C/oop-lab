package lab2.task4.coffee;

import lab2.task4.coffee.drinks.Coffee.Intensity;
import lab2.task4.coffee.drinks.Cappuccino;
import lab2.task4.coffee.drinks.Americano;
import lab2.task4.coffee.drinks.PumpkinSpiceLatte;
import lab2.task4.coffee.drinks.SyrupCappuccino;
import lab2.task4.coffee.drinks.SyrupCappuccino.SyrupType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {
    // list to store orders
    private final List<CoffeeOrder> orders = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    
    // method to take order
    public static class CoffeeOrder {
        String type;
        Intensity intensity;
        int milk;
        int water;
        SyrupType syrup;
        int pumpkinSpice;

        public CoffeeOrder(String type, Intensity intensity, int milk, int water, SyrupType syrup, int pumpkinSpice) {
            this.type = type;
            this.intensity = intensity;
            this.milk = milk;
            this.water = water;
            this.syrup = syrup;
            this.pumpkinSpice = pumpkinSpice;
        }
    }

    // method to take order
    public void takeOrder() {
        System.out.println("\nSelect coffee type:");
        System.out.println("1. Americano");
        System.out.println("2. Cappuccino");
        System.out.println("3. Syrup Cappuccino");
        System.out.println("4. Pumpkin Spice Latte");

        int choice = scanner.nextInt();
        String type;
        int milk = 0, water = 0, pumpkinSpice = 0;
        SyrupType syrup = null;

        // determine coffee type
        type = switch (choice) {
            case 1 -> "Americano";
            case 2 -> "Cappuccino";
            case 3 -> "Syrup Cappuccino";
            case 4 -> "Pumpkin Spice Latte";
            default -> "Americano";
        };

        System.out.println("Select intensity (1-LIGHT, 2-NORMAL, 3-STRONG):");
        Intensity intensity = switch (scanner.nextInt()) {
            case 1 -> Intensity.LIGHT;
            case 2 -> Intensity.NORMAL;
            default -> Intensity.STRONG;
        };

        // additional parameters based on coffee type
        switch (type) {
            case "Americano" -> {
                System.out.println("Enter water amount (ml):");
                water = scanner.nextInt();
            }
            case "Cappuccino" -> {
                System.out.println("Enter milk amount (ml):");
                milk = scanner.nextInt();
            }
            case "Syrup Cappuccino" -> {
                System.out.println("Enter milk amount (ml):");
                milk = scanner.nextInt();
                System.out.println("Select syrup (1-VANILLA, 2-CARAMEL, 3-CHOCOLATE):");
                syrup = switch (scanner.nextInt()) {
                    case 1 -> SyrupType.VANILLA;
                    case 2 -> SyrupType.CARAMEL;
                    default -> SyrupType.CHOCOLATE;
                };
            }
            case "Pumpkin Spice Latte" -> {
                System.out.println("Enter milk amount (ml):");
                milk = scanner.nextInt();
                System.out.println("Enter pumpkin spice amount (mg):");
                pumpkinSpice = scanner.nextInt();
            }
        }

        // add the order to the list
        orders.add(new CoffeeOrder(type, intensity, milk, water, syrup, pumpkinSpice));
        System.out.println("Order added successfully!");
    }
    
    // make and serve coffee
    public void serveCoffee() {
        System.out.println("Preparing all orders, total: " + orders.size());
    
        for (CoffeeOrder order : orders) {
            System.out.println("\nPreparing " + order.type + " ");
    
            switch (order.type) {
                case "Americano" -> {
                    Americano americano = new Americano(order.intensity, order.water);
                    americano.printDetails();
                }
                case "Cappuccino" -> {
                    Cappuccino cappuccino = new Cappuccino(order.intensity, order.milk);
                    cappuccino.printDetails();
                }
                case "Syrup Cappuccino" -> {
                    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(order.intensity, order.milk, order.syrup);
                    syrupCappuccino.printDetails();
                }
                case "Pumpkin Spice Latte" -> {
                    PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(order.intensity, order.milk, order.pumpkinSpice);
                    pumpkinSpiceLatte.printDetails();
                }
                default -> System.out.println("Unknown coffee type.");
            }
    
            System.out.println("Order completed\n");
        }
        // clear orders after serving
        orders.clear();
    }
    
}