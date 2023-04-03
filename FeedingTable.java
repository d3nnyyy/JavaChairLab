package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class FeedingTable extends Chair {

    private final double minHeight = 0.5;
    private final double maxHeight = 1;
    private double height;
    private final int childAge;

    FeedingTable(int maxWeight, String material,  double height, int childAge){
        super(maxWeight, material);
        if (height < minHeight || height > maxHeight){
            throw new IllegalArgumentException("Height must be between " + minHeight + " and " + maxHeight);
        }
        this.height = height;
        this.childAge = childAge;
    }

    @Override
    public void adjustPosition(int deltaHeight) {
        if (this.height + deltaHeight <= maxHeight){
            this.height += deltaHeight;
        } else {
            this.height = maxHeight;
        }
    }

    @Override
    public String toString(){
        return "FeedingTable is for " + childAge + " years old child and has a height of " + height + " meters";
    }
}
