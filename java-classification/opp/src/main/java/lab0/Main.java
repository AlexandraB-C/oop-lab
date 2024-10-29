package lab0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            
            // setup universes
            Map<String, List<Alien>> universes = new HashMap<>();
            universes.put("starWars", new ArrayList<>());
            universes.put("hitchHiker", new ArrayList<>());
            universes.put("marvel", new ArrayList<>());
            universes.put("rings", new ArrayList<>());
            
            // read and classify aliens
            int total = 0;
            int classified = 0;
            
            for (JsonNode alienJson : aliensJson) {
                total++;
                try {
                    // convert json to alien
                    Alien alien = mapper.treeToValue(alienJson, Alien.class);
                    
                    // classify alien
                    String universe = Classifier.classifyAlien(alien);
                    universes.get(universe).add(alien);
                    classified++;
                    
                    // debug print
                    System.out.println("Alien " + alien.getId() + " from " + 
                                     alien.getPlanet() + " -> " + universe);
                    
                } catch (Exception e) {
                    System.out.println("failed to process alien: " + e.getMessage());
                }
            }
            
            // print results
            System.out.println("\nClassification results:");
            System.out.println("Total aliens: " + total);
            System.out.println("Successfully classified: " + classified);
            System.out.println("\nAliens per universe:");
            for (Map.Entry<String, List<Alien>> entry : universes.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().size() + " aliens");
            }
            
        } catch (IOException e) {
            System.out.println("failed to read json: " + e.getMessage());
        }
    }
}