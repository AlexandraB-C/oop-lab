package lab2.task1;

// basic stuff all coffees need
public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name;

    public Coffee(Intensity intensity) {
        this.coffeeIntensity = intensity;
        this.name = "Coffee";
    }

    public enum Intensity {
        LIGHT, NORMAL, STRONG
    }
}