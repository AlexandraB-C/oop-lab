package lab3.Test;

import lab3.ElectricStation;
import lab3.GasStation;
import lab3.PeopleDinner;
import lab3.RobotDinner;

public class DineableRefuelableTest {
    public static void main(String[] args) {
        // test people dining
        PeopleDinner peopleDinner = new PeopleDinner();
        peopleDinner.serveDinner("Car1", true);  // dining
        peopleDinner.serveDinner("Car2", false); // not dining

        // test robot dining
        RobotDinner robotDinner = new RobotDinner();
        robotDinner.serveDinner("Car3", true);   // dining
        robotDinner.serveDinner("Car4", false);  // not dining

        // test electric refueling
        ElectricStation electricStation = new ElectricStation();
        electricStation.refuel("Car5");
        electricStation.refuel("Car6");

        // test gas refueling
        GasStation gasStation = new GasStation();
        gasStation.refuel("Car7");

        // print results
        System.out.println("\nResults:");
        System.out.println("People Served: " + PeopleDinner.getPeopleServedCount());
        System.out.println("People Not Dining: " + PeopleDinner.getPeopleNotDiningCount());
        System.out.println("Robots Served: " + RobotDinner.getRobotsServedCount());
        System.out.println("Robots Not Dining: " + RobotDinner.getRobotsNotDiningCount());
        System.out.println("Electric Cars Served: " + ElectricStation.getElectricCarsServedCount());
        System.out.println("Gas Cars Served: " + GasStation.getGasCarsServedCount());
    }
}
// javac *.java