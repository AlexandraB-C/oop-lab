package lab2.task4.coffee.drinks;

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

    @Override
    public void makeRecipe() {
        super.makeRecipe();
        System.out.println("2. Steaming " + mlOfMilk + "ml of milk");
    }
/** 
     * @return the prepared cappuccino
     */
    public Cappuccino makeCappuccino() {
        this.makeRecipe();
        return this;
    }
}