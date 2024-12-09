package lab3;

public class GasStation implements Refuelable {
    private static int gasCarsServedCount = 0;

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling gas car: " + carId);
        gasCarsServedCount++;
    }

    public static int getGasCarsServedCount() {
        return gasCarsServedCount;
    }
}