package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class OfficeChair extends Chair {

    private int angle;
    private static final int MIN_ANGLE = 90;
    private static final int MAX_ANGLE = 135;

    public OfficeChair(final int maxWeight, final String material, final int angle) {
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
        return "OfficeChair has an angle of " + angle + "degrees";
    }
}
