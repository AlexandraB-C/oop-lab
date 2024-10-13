public class Individual {
    private String name;
    private String universe;

    // Constructor
    public Individual(String name, String universe) {
        this.name = name;
        this.universe = universe;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getUniverse() {
        return universe;
    }

    // For debugging and testing
    @Override
    public String toString() {
        return "Individual: " + name + " belongs to " + universe;
    }

    public static void main(String[] args) {
        Individual person = new Individual("A", "Marvel");
        System.out.println(person);
    }
}
