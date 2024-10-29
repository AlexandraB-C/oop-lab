package lab0;

import java.util.List;

public class Classifier {
    // simple classification based on planet and traits
    public static String classifyAlien(Alien alien) {
        // check planet first
        String planet = alien.getPlanet();
        if (planet != null) {
            if (planet.equals("Kashyyyk") || planet.equals("Endor")) {
                return "starWars";
            }
            if (planet.equals("Vogsphere") || planet.equals("Betelgeuse")) {
                return "hitchHiker";
            }
            if (planet.equals("Asgard")) {
                return "marvel";
            }
        }
        
        // if no planet, check traits
        List<String> traits = alien.getTraits();
        if (traits != null) {
            for (String trait : traits) {
                switch (trait) {
                    case "POINTY_EARS":
                        return "rings";
                    case "HAIRY":
                    case "SHORT":
                        return "starWars";
                    case "GREEN":
                    case "EXTRA_HEAD":
                        return "hitchHiker";
                    case "BLONDE":
                    case "BULKY":
                        return "marvel";
                }
            }
        }
        
        // default to star wars if nothing matches
        return "starWars";
    }
}