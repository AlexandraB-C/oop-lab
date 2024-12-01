package lab2.task1;

// adds pumpkin spice to milk+coffee (cappuccino)
public class PumpkinSpiceLatte extends Cappuccino {
    protected int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, int milk, int pumpkinSpice) {
        super(intensity, milk);
        this.mgOfPumpkinSpice = pumpkinSpice;
    }
}