package lab2.task3;

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

    public SyrupCappuccino makeSyrupCappuccino() {
        super.makeCappuccino();
        System.out.println("3. Adding " + syrup + " syrup");
        return this;
    }
}