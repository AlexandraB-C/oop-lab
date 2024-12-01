package lab2.task3;

// adds milk to coffee
public class Cappuccino extends Coffee {
    protected int mlOfMilk;

    public Cappuccino(Intensity intensity, int milk) {
        super(intensity);
        this.mlOfMilk = milk;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Cappuccino milk: " + mlOfMilk + "ml");
    }

    public Cappuccino makeCappuccino() {
        super.makeCoffee();
        System.out.println("2. Steaming " + mlOfMilk + "ml of milk");
        return this;
    }
}