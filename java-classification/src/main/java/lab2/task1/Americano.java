package lab2.task1;

// adds water to coffee
public class Americano extends Coffee {
    protected int mlOfWater;

    public Americano(Intensity intensity, int water) {
        super(intensity);
        this.mlOfWater = water;
    }
}