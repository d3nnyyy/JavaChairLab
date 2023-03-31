package ua.lviv.iot.algo.part1.lab1;

public class OfficeChair extends Chair{
    private int angle;
    private static int minAngle = 90;
    private static int maxAngle = 135;

    public OfficeChair(int maxWeight, String material , int angle){
        super(maxWeight, material);
        if (angle < minAngle || angle > maxAngle){
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
    public String toString(){
        return "OfficeChair has an angle of " + angle + "degrees";
    }
}