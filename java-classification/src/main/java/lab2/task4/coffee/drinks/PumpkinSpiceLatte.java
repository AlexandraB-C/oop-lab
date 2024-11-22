package lab2.task4.coffee.drinks;

// adds pumpkin spice to milk+coffee (cappuccino)
public class PumpkinSpiceLatte extends Cappuccino {
    protected int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, int milk, int pumpkinSpice) {
        super(intensity, milk);
        this.mgOfPumpkinSpice = pumpkinSpice;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + "mg");
    }

    @Override
    public void makeRecipe() {
        super.makeRecipe();
        System.out.println("3. Adding " + mgOfPumpkinSpice + "mg of pumpkin spice");
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        // reuse the recipe of cappuccino, but do not call the specific method of the class
        System.out.println("Making a tasty pumpkin spice latte");
        this.makeRecipe();
        System.out.println("Enjoy the gifts of autumn");
        return this;
    }
}