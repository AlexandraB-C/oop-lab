package lab3;

public class GasStation implements Refuelable{
    private int refueledCount = 0;
    private int totalGasConsumption = 0;

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling gas car " + carId);
        refueledCount++;
    }
}
