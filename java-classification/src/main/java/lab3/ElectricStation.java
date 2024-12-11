package lab3;

public class ElectricStation implements Refuelable{
    private int refueledCount = 0;
    private int totalElectricConsumption = 0;

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling electric car " + carId);
        refueledCount++;
    }

}
