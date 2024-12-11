package lab3;

import java.util.HashSet;
import java.util.Set;

public class PeopleDinner implements Dineable {
    private int servedCount = 0;
    private Set<Integer> skippedCars = new HashSet<>();
    private static int totalPeople = 0;
    private static int totalDining = 0;
    private static int totalNotDining = 0;

    @Override
    public void serveDinner(Car car) {
        if (car.isDining()) {
            System.out.println("Serving dinner to people in car " + car.getId());
            servedCount++;
            totalDining++;
        } else {
            System.out.println("😔 Skipping dinner for the people in car " + car.getId());
            skippedCars.add(car.getId());
            totalNotDining++;
        }
    }

    public static void countPeople() {
        totalPeople++;
    }

    public static int getTotalPeople() {
        return totalPeople;
    }

    public static int getTotalDining() {
        return totalDining;
    }

    public static int getTotalNotDining() {
        return totalNotDining;
    }
}
