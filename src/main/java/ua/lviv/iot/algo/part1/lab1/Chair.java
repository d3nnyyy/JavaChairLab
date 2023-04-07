package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
abstract public class Chair {

    protected int maxWeight;
    protected String material;

    public abstract void adjustPosition(int value);
}
