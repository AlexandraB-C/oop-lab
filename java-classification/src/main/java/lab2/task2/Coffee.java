package lab2.task2;

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
}