package lab3.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import lab3.Car;
import lab3.CarStation;
import lab3.LinkedQueue;
import lab3.PeopleDinner;
import lab3.Queue;
import lab3.Semaphore;
import lab3.ElectricStation;
import lab3.GasStation;
import lab3.RobotDinner;


public class SemaphoreTest {
    private Semaphore semaphore;
    private String testFolderPath;
    private ObjectMapper objectMapper;
    private CarStation gasStationWithPeople;
    private CarStation gasStationWithRobots;
    private CarStation electricStationWithPeople;
    private CarStation electricStationWithRobots;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary test folder
        testFolderPath = "test-queue";
        Files.createDirectories(Paths.get(testFolderPath));

        // Initialize semaphore and stations
        semaphore = new Semaphore();
        
        // Create queues
        Queue<Car> gasQueueWithPeople = new LinkedQueue<>();
        Queue<Car> gasQueueWithRobots = new LinkedQueue<>();
        Queue<Car> electricQueueWithPeople = new LinkedQueue<>();
        Queue<Car> electricQueueWithRobots = new LinkedQueue<>();

        // Create stations
        gasStationWithPeople = new CarStation(new PeopleDinner(), new GasStation(), gasQueueWithPeople);
        gasStationWithRobots = new CarStation(new RobotDinner(), new GasStation(), gasQueueWithRobots);
        electricStationWithPeople = new CarStation(new PeopleDinner(), new ElectricStation(), electricQueueWithPeople);
        electricStationWithRobots = new CarStation(new RobotDinner(), new ElectricStation(), electricQueueWithRobots);

        // Register stations
        semaphore.registerStation("GAS_PEOPLE", gasStationWithPeople);
        semaphore.registerStation("GAS_ROBOTS", gasStationWithRobots);
        semaphore.registerStation("ELECTRIC_PEOPLE", electricStationWithPeople);
        semaphore.registerStation("ELECTRIC_ROBOTS", electricStationWithRobots);
        
        objectMapper = new ObjectMapper();
    }

    // Task 1: Queue Implementation Test
    @Test
    public void testQueueImplementation() {
        Queue<Integer> testQueue = new LinkedQueue<>();
        
        // Test enqueue and size
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        assertEquals(2, testQueue.size(), "Queue size should be 2");
        
        // Test dequeue
        assertEquals(1, testQueue.dequeue(), "First dequeued item should be 1");
        assertEquals(1, testQueue.size(), "Queue size should be 1 after dequeue");
        
        // Test isEmpty
        testQueue.dequeue();
        assertTrue(testQueue.isEmpty(), "Queue should be empty after dequeuing all items");
    }

    // Task 3: Composition and Dependency Injection Test
    @Test
    public void testCarStationComposition() {
        Car testCar = new Car(1, "GAS", "PEOPLE", true, 40);
        
        // Add car to station
        gasStationWithPeople.addCar(testCar);
        
        // Serve cars
        gasStationWithPeople.serveCars();
        
        // Check statistics
        assertEquals(1, gasStationWithPeople.getTotalCarsProcessed(), "Total cars processed should be 1");
        assertEquals(40, gasStationWithPeople.getTotalConsumption(), "Total consumption should match");
    }

    // Task 4: Scheduler Simulation Test
    @Test
    public void testSchedulerSimulation() {
        // Create multiple cars
        Car[] testCars = {
            new Car(1, "GAS", "PEOPLE", true, 40),
            new Car(2, "ELECTRIC", "ROBOTS", false, 30),
            new Car(3, "GAS", "ROBOTS", true, 35)
        };

        // Add cars to appropriate stations
        gasStationWithPeople.addCar(testCars[0]);
        electricStationWithRobots.addCar(testCars[1]);
        gasStationWithRobots.addCar(testCars[2]);

        // Simulate serving cars
        semaphore.serveAll();

        // Check total cars processed
        assertEquals(1, gasStationWithPeople.getTotalCarsProcessed());
        assertEquals(1, electricStationWithRobots.getTotalCarsProcessed());
        assertEquals(1, gasStationWithRobots.getTotalCarsProcessed());
    }

    public void tearDown() throws IOException {
        Files.walk(Paths.get(testFolderPath))
             .map(Path::toFile)
             .forEach(File::delete);
    }
}