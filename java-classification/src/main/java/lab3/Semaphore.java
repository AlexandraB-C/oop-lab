package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Semaphore {
    private Map<String, CarStation> stations;
    private ObjectMapper objectMapper;
    private long lastCarAddedTime;

    public Semaphore() {
        this.stations = new HashMap<>();
        this.objectMapper = new ObjectMapper();
        this.lastCarAddedTime = System.currentTimeMillis();
    }

    public void registerStation(String type, CarStation station) {
        stations.put(type, station);
    }

    public void initializeQueue(String folderPath) {
        try {
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
                System.out.println("Created folder: " + folderPath);
                return;
            }

            File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
            if (files != null) {
                for (File file : files) {
                    processFile(file);
                }
            }
        } catch (Exception e) {
            System.err.println("Error initializing queue: " + e.getMessage());
        }
    }

    public void monitorQueueFolder(String folderPath) {
        try {
            Path path = Paths.get(folderPath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("Created folder: " + folderPath);
            }

            try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
                path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
                System.out.println("Monitoring folder: " + folderPath);

                while (true) {
                    WatchKey key = watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();

                        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                            String fileName = event.context().toString();
                            if (fileName.endsWith(".json")) {
                                processFile(new File(folderPath + "/" + fileName));
                                lastCarAddedTime = System.currentTimeMillis();
                            }
                        }
                    }
                    key.reset();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processFile(File file) {
        try {
            Car car = objectMapper.readValue(file, Car.class);

            String stationKey = car.getType() + "_" + car.getPassengers();
            CarStation station = stations.get(stationKey);

            if (station != null) {
                station.addCar(car);
                System.out.println("Car " + car.getId() + " added to " + stationKey + " station.");
            } else {
                System.err.println("No station registered for car type: " + stationKey);
            }

            if (!file.delete()) {
                System.err.println("Failed to delete file: " + file.getName());
            }
        } catch (Exception e) {
            System.err.println("Failed to process file: " + file.getName() + " - " + e.getMessage());
        }
    }


    public void serveAll() {
        stations.values().forEach(CarStation::serveCars);
        printTotalsIfIdle();
    }

    private void printTotalsIfIdle() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastCarAddedTime > 5000) {
            printTotals();
            shutdownProgram();
        }
    }

    private void shutdownProgram() {
        System.out.println(":)...");
        System.exit(0);
    }

    private void printTotals() {
        int totalPeople = PeopleDinner.getTotalPeople();
        int totalRobots = RobotDinner.getTotalRobots();
        int totalDining = PeopleDinner.getTotalDining() + RobotDinner.getTotalDining();
        int totalNotDining = PeopleDinner.getTotalNotDining() + RobotDinner.getTotalNotDining();

        Map<String, Integer> typeCounts = new HashMap<>();
        Map<String, Integer> consumptionTotals = new HashMap<>();

        typeCounts.put("GAS", 0);
        typeCounts.put("ELECTRIC", 0);
        consumptionTotals.put("GAS", 0);
        consumptionTotals.put("ELECTRIC", 0);

        for (Map.Entry<String, CarStation> entry : stations.entrySet()) {
            String stationKey = entry.getKey();
            CarStation station = entry.getValue();

            if (stationKey.startsWith("GAS")) {
                typeCounts.put("GAS", typeCounts.get("GAS") + station.getTotalCarsProcessed());
                consumptionTotals.put("GAS", consumptionTotals.get("GAS") + station.getTotalConsumption());
            } else if (stationKey.startsWith("ELECTRIC")) {
                typeCounts.put("ELECTRIC", typeCounts.get("ELECTRIC") + station.getTotalCarsProcessed());
                consumptionTotals.put("ELECTRIC", consumptionTotals.get("ELECTRIC") + station.getTotalConsumption());
            }
        }

        System.out.println("Totals:");
        System.out.println("ELECTRIC: " + typeCounts.get("ELECTRIC") + "\n" +
                "GAS: " + typeCounts.get("GAS") + "\n" +
                "PEOPLE: " + totalPeople  + "\n" +
                "ROBOTS: " + totalRobots + "\n" +
                "DINING: " + totalDining + "\n" +
                "NOT_DINING: " + totalNotDining + "\n" +
                "    CONSUMPTION:" + "\n ELECTRIC: " + consumptionTotals.get("ELECTRIC") +
                ", GAS: " + consumptionTotals.get("GAS"));
    }

}

