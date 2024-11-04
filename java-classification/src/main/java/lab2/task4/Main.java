package lab2.task4;

import lab2.task4.coffee.Barista;
import lab2.task4.coffee.drinks.Coffee.Intensity;

public class Main {
    public static void main(String[] args) {
        // create barista
        Barista barista = new Barista();
        
        // place some orders
        barista.takeOrder("Pumpkin Spice Latte", Intensity.LIGHT);
        barista.takeOrder("Cappuccino", Intensity.STRONG);
        
        // barista makes all orders
        barista.serveCoffee();
    }
}