package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class ReclinerChair extends Chair {

    private static final int MIN_ANGLE = 90;
    private static final int MAX_ANGLE = 150;
    private int angle;

    public ReclinerChair(final int maxWeight, final String material, final int angle) {
        super(maxWeight, material);
        if (angle < MIN_ANGLE || angle > MAX_ANGLE) {
            throw new IllegalArgumentException("Angle must be between "
                    + MIN_ANGLE + " and " + MAX_ANGLE);
        }
        this.angle = angle;
    }

    @Override
    public final void adjustPosition(final int deltaAngle) {
        if (this.angle + deltaAngle <= MAX_ANGLE && this.angle + deltaAngle >= MIN_ANGLE) {
            this.angle += deltaAngle;
        } else if (this.angle + deltaAngle > MAX_ANGLE) {
            this.angle = MAX_ANGLE;
        } else {
            this.angle = MIN_ANGLE;
        }
    }

    @Override
    public final String toString() {
        return "ReclinerChair has an angle of " + angle + " degrees";
    }
}

