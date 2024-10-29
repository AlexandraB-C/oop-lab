package lab0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try {
            // setup mapper
            ObjectMapper mapper = new ObjectMapper();
            
            // try read file
            File inputFile = new File("opp/src/main/resources/input.json");
            JsonNode rootNode = mapper.readTree(inputFile);
            JsonNode aliensJson = rootNode.get("data");
            
            // store all aliens here
            List<Alien> allAliens = new ArrayList<>();
            
            // convert each json to alien object
            for (JsonNode alienJson : aliensJson) {
                try {
                    Alien alien = mapper.treeToValue(alienJson, Alien.class);
                    allAliens.add(alien);
                } catch (Exception e) {
                    // skip bad aliens
                    System.out.println("failed to parse alien: " + alienJson);
                }
            }
            
            // print all aliens
            System.out.println("\nAll aliens loaded: " + allAliens.size());
            for (Alien a : allAliens) {
                System.out.println(a);
            }
            
            // do some testing with filters
            System.out.println("\nJust humanoid aliens:");
            for (Alien a : allAliens) {
                if (a.getIsHumanoid() != null && a.getIsHumanoid()) {
                    System.out.println("- " + a.getPlanet());
                }
            }
            
            // test filtering by id
            System.out.println("\nAliens with even IDs:");
            for (Alien a : allAliens) {
                if (a.getId() % 2 == 0) {
                    System.out.println("- ID " + a.getId());
                }
            }
            
        } catch (IOException e) {
            System.out.println("failed to read json: " + e.getMessage());
        }
    }
}