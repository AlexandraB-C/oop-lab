package lab2.task1;

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
}