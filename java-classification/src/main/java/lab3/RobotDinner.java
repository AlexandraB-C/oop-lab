package lab3;

public class RobotDinner implements Dineable {
    private static int robotsServedCount = 0;

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to robots in car: " + carId);
        robotsServedCount++;
    }

    public static int getRobotsServedCount() {
        return robotsServedCount;
    }
}