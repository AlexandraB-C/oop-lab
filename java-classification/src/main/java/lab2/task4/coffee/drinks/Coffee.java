package lab2.task4.coffee.drinks;

// basic stuff all coffees need
public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name;

    public Coffee(Intensity strong) {
        this.coffeeIntensity = strong;
        this.name = "Coffee";
    }

    public enum Intensity {
        LIGHT, NORMAL, STRONG
    }

    public void printDetails() {
        
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }

    protected Coffee makeCoffee() {
        System.out.println("1. Brewing coffee with " + coffeeIntensity + " intensity");
        return this;
    }
}