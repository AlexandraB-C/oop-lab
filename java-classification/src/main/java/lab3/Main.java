package lab3;

public class Main {
    public static void main(String[] args) {
        String folderPath = "java-classification\\\\src\\\\main\\\\java\\\\lab3\\\\queue";
        //String folderPath = "oop-lab\\queue";

        Semaphore semaphore = new Semaphore();

        Queue<Car> gasQueueWithPeople = new LinkedQueue<>();
        Queue<Car> gasQueueWithRobots = new LinkedQueue<>();
        Queue<Car> electricQueueWithPeople = new LinkedQueue<>();
        Queue<Car> electricQueueWithRobots = new LinkedQueue<>();

        CarStation gasStationWithPeople = new CarStation(new PeopleDinner(), new GasStation(), gasQueueWithPeople);
        CarStation gasStationWithRobots = new CarStation(new RobotDinner(), new GasStation(), gasQueueWithRobots);
        CarStation electricStationWithPeople = new CarStation(new PeopleDinner(), new ElectricStation(), electricQueueWithPeople);
        CarStation electricStationWithRobots = new CarStation(new RobotDinner(), new ElectricStation(), electricQueueWithRobots);

        semaphore.registerStation("GAS_PEOPLE", gasStationWithPeople);
        semaphore.registerStation("GAS_ROBOTS", gasStationWithRobots);
        semaphore.registerStation("ELECTRIC_PEOPLE", electricStationWithPeople);
        semaphore.registerStation("ELECTRIC_ROBOTS", electricStationWithRobots);

        Scheduler scheduler = new Scheduler(semaphore);
        
        Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
        
        scheduler.startScheduler(folderPath);
    }
}