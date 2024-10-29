package lab0;

import java.util.List;

// added more fields to match json
public class Alien {
    private int id;
    private Boolean isHumanoid;
    private String planet;
    private Integer age;
    private List<String> traits;
    
    // empty constructor 
    public Alien() {
    }

    // basic toString for testing
    @Override
    public String toString() {
        return "Alien{" +
            "id=" + id +
            ", planet='" + planet + '\'' +
            ", traits=" + traits +
            '}';
    }
    
    // all getters/setters needed for json mapping
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsHumanoid() {
        return isHumanoid;
    }

    public void setIsHumanoid(Boolean humanoid) {
        isHumanoid = humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public List<String> getTraits() {
        return traits;
    }
    
    public void setTraits(List<String> traits) {
        this.traits = traits;
    }
}