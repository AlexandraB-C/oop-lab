package lab2.task1;

// adds milk to coffee
public class Cappuccino extends Coffee {
    protected int mlOfMilk;

    public Cappuccino(Intensity intensity, int milk) {
        super(intensity);
        this.mlOfMilk = milk;
    }
}