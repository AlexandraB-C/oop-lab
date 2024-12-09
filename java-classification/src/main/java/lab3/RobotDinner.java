package lab3;

public class RobotDinner implements Dineable {
    private static int robotsServedCount = 0;
    private static int robotsNotDiningCount = 0;

    @Override
    public void serveDinner(String carId, boolean shouldDine) {
        if (shouldDine) {
            System.out.println("Serving dinner to robots in car " + carId);
            robotsServedCount++;
        } else {
            System.out.println("Robots in car " + carId + " chose not to dine");
            robotsNotDiningCount++;
        }
    }

    public static int getRobotsServedCount() {
        return robotsServedCount;
    }

    public static int getRobotsNotDiningCount() {
        return robotsNotDiningCount;
    }
}