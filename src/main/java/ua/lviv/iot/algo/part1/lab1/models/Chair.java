package ua.lviv.iot.algo.part1.lab1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public abstract class Chair {

    public static final String HEADERS = "maxWeight, material";
    private int maxWeight;
    private String material;

    public abstract void adjustPosition(int value);

    public String getHeaders() {
        return HEADERS;
    }

    public String toCSV() {
        return maxWeight + ", " + material;
    }
}
