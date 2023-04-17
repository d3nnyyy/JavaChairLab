package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class Chair {

    private int maxWeight;
    private String material;
    public abstract void adjustPosition(int value);
}
