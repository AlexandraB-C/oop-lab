package lab3;

import java.util.HashSet;
import java.util.Set;

public class RobotDinner implements Dineable {
    private int servedCount = 0;
    private Set<Integer> skippedCars = new HashSet<>();
    private static int totalRobots = 0;
    private static int totalDining = 0;
    private static int totalNotDining = 0;

    @Override
    public void serveDinner(Car car) {
        if (car.isDining()) {
            System.out.println("Serving dinner to robots in car " + car.getId());
            servedCount++;
            totalDining++;
        } else {
            System.out.println("😔 Skipping dinner for the robots in car " + car.getId());
            skippedCars.add(car.getId());
            totalNotDining++;
        }
    }

    public static void countRobots() {
        totalRobots++;
    }

    public static int getTotalRobots() {
        return totalRobots;
    }

    public static int getTotalDining() {
        return totalDining;
    }

    public static int getTotalNotDining() {
        return totalNotDining;
    }
}
