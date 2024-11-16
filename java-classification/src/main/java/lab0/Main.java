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
            File inputFile = new File("java-classification/src/main/resources/input.json");
            JsonNode rootNode = mapper.readTree(inputFile);
            JsonNode aliensJson = rootNode.get("data");
            
            // setup universes
            Map<String, List<Alien>> universes = new HashMap<>();
            universes.put("starWars", new ArrayList<>());
            universes.put("hitchHiker", new ArrayList<>());
            universes.put("marvel", new ArrayList<>());
            universes.put("rings", new ArrayList<>());
            
            // classify aliens
            for (JsonNode alienJson : aliensJson) {
                try {
                    Alien alien = mapper.treeToValue(alienJson, Alien.class);
                    String universe = Classifier.classifyAlien(alien);
                    universes.get(universe).add(alien);
                } catch (Exception e) {
                    System.out.println("failed to process alien: " + e.getMessage());
                }
            }
            
            // make output folder
            File outputDir = new File("java-classification/src/main/resources/output");
            outputDir.mkdirs();
            
            // save each universe to its own file
            for (Map.Entry<String, List<Alien>> entry : universes.entrySet()) {
                try {
                    String name = entry.getKey();
                    List<Alien> aliens = entry.getValue();
                    
                    // create output object
                    Map<String, Object> output = new HashMap<>();
                    output.put("universe", name);
                    output.put("aliens", aliens);
                    
                    // save to file
                    File outFile = new File(outputDir, name.toLowerCase() + ".json");
                    mapper.writerWithDefaultPrettyPrinter()
                          .writeValue(outFile, output);
                    
                    System.out.println("Saved " + aliens.size() + 
                                     " aliens to " + outFile.getName());
                    
                } catch (IOException e) {
                    System.out.println("failed to save universe: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            System.out.println("failed to read input: " + e.getMessage());
        }
    }
}