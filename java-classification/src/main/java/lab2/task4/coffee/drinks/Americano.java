package lab2.task4.coffee.drinks;

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

    @Override
    public void makeRecipe() {
        super.makeRecipe();
        System.out.println("2. Adding " + mlOfWater + "ml of hot water");
    }

    public Americano makeAmericano() {
        System.out.println("Making an americano");
        this.makeRecipe();
        System.out.println("Enjoy the gifts of summer");

        return this;
    }
}