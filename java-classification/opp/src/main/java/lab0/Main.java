package lab0;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        try {
            // init json reader
            ObjectMapper mapper = new ObjectMapper();
            
            // try read file
            File inputFile = new File("opp/src/main/resources/test-input.json");
            JsonNode rootNode = mapper.readTree(inputFile);
            JsonNode aliens = rootNode.get("data");
            
            // print each alien for testing
            System.out.println("found " + aliens.size() + " aliens:");
            for (JsonNode alien : aliens) {
                System.out.println("-----------------");
                System.out.println("id: " + alien.get("id").asText());
                if (alien.has("planet")) {
                    System.out.println("planet: " + alien.get("planet").asText());
                }
                if (alien.has("isHumanoid")) {
                    System.out.println("humanoid: " + alien.get("isHumanoid").asText());
                }
            }
            
        } catch (IOException e) {
            System.out.println("failed to read json: " + e.getMessage());
        }
    }
}