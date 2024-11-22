package lab2.task4.coffee.drinks;

// adds syrup to milk+coffee (cappuccino)
public class SyrupCappuccino extends Cappuccino {
    protected SyrupType syrup;

    public SyrupCappuccino(Intensity intensity, int milk, SyrupType syrupType) {
        super(intensity, milk);
        this.syrup = syrupType;
    }

    public enum SyrupType {
        MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Syrup: " + syrup);
    }

    @Override
    public void makeRecipe() {
        super.makeRecipe();
        System.out.println("3. Adding " + syrup + " syrup");
    }

    public SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making a syrup cappuccino");
        this.makeRecipe();
        System.out.println("Enjoy the gifts of autumn");
        return this;
    }
}