package lab3;

public class ElectricStation implements Refuelable {
    private static int electricCarsServedCount = 0;

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car: " + carId);
        electricCarsServedCount++;
    }

    public static int getElectricCarsServedCount() {
        return electricCarsServedCount;
    }
}