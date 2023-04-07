package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

@Getter
public class ReclinerChair extends Chair {

    private final int minAngle = 90;
    private final int maxAngle = 150;
    private int angle;

    public ReclinerChair(int maxWeight, String material, int angle) {
        super(maxWeight, material);
        if (angle < minAngle || angle > maxAngle) {
            throw new IllegalArgumentException("Angle must be between " + minAngle + " and " + maxAngle);
        }
        this.angle = angle;
    }

    @Override
    public void adjustPosition(int deltaAngle) {
        if (this.angle + deltaAngle <= maxAngle && this.angle + deltaAngle >= minAngle) {
            this.angle += deltaAngle;
        } else if (this.angle + deltaAngle > maxAngle) {
            this.angle = maxAngle;
        } else {
            this.angle = minAngle;
        }
    }

    @Override
    public String toString() {
        return "ReclinerChair has an angle of " + angle + " degrees";
    }
}

