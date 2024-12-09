package lab3;
import lab3.Queue_1.Queue;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private final Queue<Car> queue;

    // constructor with dependency injection
    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            
            // serve dinner based on passenger type and dining preference
            if (car.isDining()) {
                if (car.getPassengers().equals("PEOPLE")) {
                    diningService = new PeopleDinner();
                } else if (car.getPassengers().equals("ROBOTS")) {
                    diningService = new RobotDinner();
                }
                diningService.serveDinner(String.valueOf(car.getId()), car.isDining());
            }

            if (car.getType().equals("ELECTRIC")) {
                refuelingService = new ElectricStation();
            } else if (car.getType().equals("GAS")) {
                refuelingService = new GasStation();
            }
            refuelingService.refuel(String.valueOf(car.getId()));
        }
    }
}