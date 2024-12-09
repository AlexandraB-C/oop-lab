package lab3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final int id;
    private final String type;
    private final String passengers;
    private final boolean isDining;
    private final int consumption;

    @JsonCreator
    public Car(
            @JsonProperty("id") int id,
            @JsonProperty("type") String type,
            @JsonProperty("passengers") String passengers,
            @JsonProperty("isDining") boolean isDining,
            @JsonProperty("consumption") int consumption
    ) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassengers() {
        return passengers;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumption;
    }
}