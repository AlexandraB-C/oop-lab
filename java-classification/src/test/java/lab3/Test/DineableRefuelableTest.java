package lab3.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.ElectricStation;
import lab3.GasStation;
import lab3.PeopleDinner;
import lab3.RobotDinner;

public class DineableRefuelableTest {
    private PeopleDinner peopleDinner;
    private RobotDinner robotDinner;
    private ElectricStation electricStation;
    private GasStation gasStation;

    @BeforeEach
    public void setUp() {
        // reset static counters before each test
        try {
            java.lang.reflect.Field peopleCountField = PeopleDinner.class.getDeclaredField("peopleServedCount");
            peopleCountField.setAccessible(true);
            java.lang.reflect.Field modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(peopleCountField, peopleCountField.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
            peopleCountField.set(null, 0);

            // Similar reset for other static counters
            java.lang.reflect.Field robotCountField = RobotDinner.class.getDeclaredField("robotsServedCount");
            robotCountField.setAccessible(true);
            robotCountField.set(null, 0);

            java.lang.reflect.Field electricCountField = ElectricStation.class.getDeclaredField("electricCarsServedCount");
            electricCountField.setAccessible(true);
            electricCountField.set(null, 0);

            java.lang.reflect.Field gasCountField = GasStation.class.getDeclaredField("gasCarsServedCount");
            gasCountField.setAccessible(true);
            gasCountField.set(null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        peopleDinner = new PeopleDinner();
        robotDinner = new RobotDinner();
        electricStation = new ElectricStation();
        gasStation = new GasStation();
    }

    @Test
    public void testPeopleDining() {
        peopleDinner.serveDinner("Car1", true);
        peopleDinner.serveDinner("Car2", false);

        assertEquals(1, PeopleDinner.getPeopleServedCount());
        assertEquals(1, PeopleDinner.getPeopleNotDiningCount());
    }

    @Test
    public void testRobotDining() {
        robotDinner.serveDinner("Car3", true);
        robotDinner.serveDinner("Car4", false);

        assertEquals(1, RobotDinner.getRobotsServedCount());
        assertEquals(1, RobotDinner.getRobotsNotDiningCount());
    }

    @Test
    public void testRefueling() {
        electricStation.refuel("Car5");
        electricStation.refuel("Car6");
        gasStation.refuel("Car7");

        assertEquals(2, ElectricStation.getElectricCarsServedCount());
        assertEquals(1, GasStation.getGasCarsServedCount());
    }
}