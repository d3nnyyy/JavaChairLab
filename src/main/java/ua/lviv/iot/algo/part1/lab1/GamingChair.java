package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class GamingChair extends Chair {

    private static final double MIN_HEIGHT = 1.2;
    private static final double MAX_HEIGHT = 1.8;
    private double height;
    private final boolean hasFootrest;

    GamingChair(final int maxWeight, final String material, final double height, final boolean hasFootrest) {
        super(maxWeight, material);
        if (height > MIN_HEIGHT && height < MAX_HEIGHT) {
            this.height = height;
            this.hasFootrest = hasFootrest;
        } else {
            throw new IllegalArgumentException("Height must be between "
                    + MIN_HEIGHT + " and " + MAX_HEIGHT);
        }
    }

    @Override
    public final void adjustPosition(final int deltaHeight) {
        if (this.height + deltaHeight <= MAX_HEIGHT && this.height + deltaHeight >= MIN_HEIGHT) {
            this.height += deltaHeight;
        } else if (this.height + deltaHeight > MAX_HEIGHT) {
            this.height = MAX_HEIGHT;
        } else if (this.height + deltaHeight < MIN_HEIGHT) {
            this.height = MIN_HEIGHT;
        }
    }

    @Override
    public final String toString() {
        return "GamingChair has a height of " + height + " meters and " + (hasFootrest ? "has a footrest." : "does not have a footrest.");
    }
}
