package lab3;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> carQueue;

    private int totalCarsProcessed = 0;
    private int totalConsumption = 0;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> carQueue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.carQueue = carQueue;
    }

    public void addCar(Car car) {
        carQueue.enqueue(car);
    }

    public void serveCars() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.dequeue();
            if (car.getPassengers().equals("ROBOTS")){
                RobotDinner.countRobots();
            }
            if (car.getPassengers().equals("PEOPLE")){
                PeopleDinner.countPeople();
            }
            diningService.serveDinner(car);

            refuelingService.refuel(car.getId());
            totalCarsProcessed++;
            totalConsumption += car.getConsumption();
            System.out.println("Car " + car.getId() + " has been served.\n");
        }
    }

    public int getTotalCarsProcessed() {
        return totalCarsProcessed;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

}
