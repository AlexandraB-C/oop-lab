package lab3;

public class PeopleDinner implements Dineable {
    private static int peopleServedCount = 0;

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to people in car:" + carId);
        peopleServedCount++;
    }

    public static int getPeopleServedCount() {
        return peopleServedCount;
    }
}