package lab2.task2;

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
}