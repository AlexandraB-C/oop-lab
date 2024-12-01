package lab2.task2;

// adds water to coffee
public class Americano extends Coffee {
    protected int mlOfWater;

    public Americano(Intensity intensity, int water) {
        super(intensity);
        this.mlOfWater = water;
    }

    @Override
    public void printDetails() {
        
        System.out.println("Americano: " + mlOfWater + "ml of water");
    }
}