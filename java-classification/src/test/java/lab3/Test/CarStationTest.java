package lab3.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.Car;
import lab3.CarStation;
import lab3.ElectricStation;
import lab3.GasStation;
import lab3.PeopleDinner;
import lab3.Queue_1.LinkedQueue;
import lab3.Queue_1.Queue;
import lab3.RobotDinner;

public class CarStationTest {
    private Queue<Car> queue;
    private PeopleDinner peopleDinner;
    private RobotDinner robotDinner;
    private ElectricStation electricStation;
    private GasStation gasStation;

    @BeforeEach
    public void setUp() {
        try {
            java.lang.reflect.Field[] fields = {
                PeopleDinner.class.getDeclaredField("peopleServedCount"),
                RobotDinner.class.getDeclaredField("robotsServedCount"),
                ElectricStation.class.getDeclaredField("electricCarsServedCount"),
                GasStation.class.getDeclaredField("gasCarsServedCount")
            };

            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                java.lang.reflect.Field modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
                field.set(null, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        queue = new LinkedQueue<>();
        peopleDinner = new PeopleDinner();
        robotDinner = new RobotDinner();
        electricStation = new ElectricStation();
        gasStation = new GasStation();
    }

    @Test
    public void testCarStationWithPeopleDiningElectricCar() {
        // Electric car with people dining
        Car electricPeopleDiningCar = new Car(1, "ELECTRIC", "PEOPLE", true, 42);
        
        CarStation carStation = new CarStation(peopleDinner, electricStation, queue);
        carStation.addCar(electricPeopleDiningCar);
        carStation.serveCars();

        assertEquals(1, PeopleDinner.getPeopleServedCount());
        assertEquals(1, ElectricStation.getElectricCarsServedCount());
    }


}