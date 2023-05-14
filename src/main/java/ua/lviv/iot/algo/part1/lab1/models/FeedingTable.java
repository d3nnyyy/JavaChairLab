package ua.lviv.iot.algo.part1.lab1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
public class FeedingTable extends Chair {

    public static final double MIN_HEIGHT = 0.5;
    public static final double MAX_HEIGHT = 1;
    private Integer id;
    private double height;
    private final int childAge;

    public FeedingTable(final int maxWeight, final String material, final double height, final int childAge) {
        super(maxWeight, material);
        this.height = height;
        this.childAge = childAge;
    }

    public String getHeaders() {
        return super.getHeaders() + ", id, MIN_HEIGHT, MAX_HEIGHT, height, childAge";
    }

    public String toCSV() {
        return super.toCSV() + ", " + id + ", " + MIN_HEIGHT + ", " + MAX_HEIGHT + ", " + height + ", " + childAge;
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
