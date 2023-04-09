package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class GamingChair extends Chair {

    private final double minHeight = 1.2;
    private final double maxHeight = 1.8;
    private double height;
    private final boolean hasFootrest;

    GamingChair(int maxWeight, String material, double height, boolean hasFootrest) {
        super(maxWeight, material);
        if (height > minHeight && height < maxHeight) {
            this.height = height;
            this.hasFootrest = hasFootrest;
        }
        else {
            throw new IllegalArgumentException("Height must be between " + minHeight + " and " + maxHeight);
        }
    }

    @Override
    public void adjustPosition(int deltaHeight) {
        if (this.height + deltaHeight <= maxHeight && this.height + deltaHeight >= minHeight) {
            this.height += deltaHeight;
        } else if (this.height + deltaHeight > maxHeight) {
            this.height = maxHeight;
        } else if (this.height + deltaHeight < minHeight) {
            this.height = minHeight;
        }
    }

    @Override
    public String toString() {
        return "GamingChair has a height of " + height + " meters and " + (hasFootrest ? "has a footrest." : "does not have a footrest.");
    }
}