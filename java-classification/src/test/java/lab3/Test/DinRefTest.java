package lab3.Test;

import lab3.ElectricStation;
import lab3.GasStation;
import lab3.PeopleDinner;
import lab3.RobotDinner;

public class DinRefTest {
    public static void main(String[] args) {
        // test people dining
        PeopleDinner peopleDinner = new PeopleDinner();
        peopleDinner.serveDinner("Car1");
        peopleDinner.serveDinner("Car2");

        // test robot dining
        RobotDinner robotDinner = new RobotDinner();
        robotDinner.serveDinner("Car3");

        // test electric refueling
        ElectricStation electricStation = new ElectricStation();
        electricStation.refuel("Car4");
        electricStation.refuel("Car5");

        // test gas refueling
        GasStation gasStation = new GasStation();
        gasStation.refuel("Car6");

        // print results
        System.out.println("\nResults:");
        System.out.println("People Served: " + PeopleDinner.getPeopleServedCount());
        System.out.println("Robots Served: " + RobotDinner.getRobotsServedCount());
        System.out.println("Electric Cars Served: " + ElectricStation.getElectricCarsServedCount());
        System.out.println("Gas Cars Served: " + GasStation.getGasCarsServedCount());
    }
}
// javac *.java