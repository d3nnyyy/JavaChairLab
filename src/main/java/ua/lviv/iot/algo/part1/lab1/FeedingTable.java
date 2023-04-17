package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class FeedingTable extends Chair {

    public static final double MIN_HEIGHT = 0.5;
    public static final double MAX_HEIGHT = 1;
    private double height;
    private final int childAge;

    FeedingTable(final int maxWeight, final String material,  final double height, final int childAge) {
        super(maxWeight, material);
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    "Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT
            );
        }
        this.height = height;
        this.childAge = childAge;
    }

    public String getHeaders() {
        return super.getHeaders() + ", MIN_HEIGHT, MAX_HEIGHT, height, childAge";
    }

    public String toCSV() {
        return super.toCSV() + ", " + MIN_HEIGHT + ", " + MAX_HEIGHT + ", " + height + ", " + childAge;
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
        return "FeedingTable is for "
                + childAge + " years old child and has a height of "
                + height + " meters";
    }
}
