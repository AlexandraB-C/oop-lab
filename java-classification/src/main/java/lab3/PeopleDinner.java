package lab3;

public class PeopleDinner implements Dineable {
    private static int peopleServedCount = 0;
    private static int peopleNotDiningCount = 0;

    @Override
    public void serveDinner(String carId, boolean shouldDine) {
        if (shouldDine) {
            System.out.println("Serving dinner to people in car " + carId);
            peopleServedCount++;
        } else {
            System.out.println("People in car " + carId + " chose not to dine");
            peopleNotDiningCount++;
        }
    }

    public static int getPeopleServedCount() {
        return peopleServedCount;
    }

    public static int getPeopleNotDiningCount() {
        return peopleNotDiningCount;
    }
}