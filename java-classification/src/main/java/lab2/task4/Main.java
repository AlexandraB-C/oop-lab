package lab2.task4;

import java.util.Scanner;

import lab2.task4.coffee.Barista;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCoffee Menu:");
            System.out.println("1. Make order");
            System.out.println("2. Prepare the order");
            System.out.println("3. Exit");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> barista.takeOrder();
                case 2 -> barista.serveCoffee();
                case 3 -> {
                    System.out.println("Thank you :)");
                    return;
                }
            }
        }
    }
}