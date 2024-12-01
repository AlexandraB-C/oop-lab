package lab2.task2;

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
}