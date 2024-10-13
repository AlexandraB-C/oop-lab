import java.util.List;

public class Individual {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    // Empty constructor for Gson
    public Individual() {}

    // Getters and setters
    public int getId() { return id; }
    public boolean isHumanoid() { return isHumanoid; }
    public String getPlanet() { return planet; }
    public int getAge() { return age; }
    public List<String> getTraits() { return traits; }

    @Override
    public String toString() {
        return "Individual{" +
               "id=" + id +
               ", isHumanoid=" + isHumanoid +
               ", planet='" + planet + '\'' +
               ", age=" + age +
               ", traits=" + traits +
               '}';
    }

    public static void main(String[] args) {
    JsonReader jsonReader = new JsonReader();
    List<Individual> individuals = jsonReader.readJson("input.json");
    if (individuals != null) {
        for (Individual individual : individuals) {
            System.out.println(individual);
        }
    } else {
        System.out.println("Failed to read individuals from JSON.");
    }
}
}