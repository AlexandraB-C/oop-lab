package lab0;
public class Alien {
    private int id;
    private Boolean isHumanoid;
    private String planet;
    
    // empty constructor
    public Alien() {
    }
    
    // basic getters/setters
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
}