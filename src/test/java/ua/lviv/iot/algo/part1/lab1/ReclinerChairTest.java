package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ReclinerChairTest {

    ReclinerChair reclinerChair = new ReclinerChair(200, "Leather", 120);

    @Test
    public void testConstructor() {
        Assertions.assertEquals(200, reclinerChair.getMaxWeight());
        Assertions.assertEquals("Leather", reclinerChair.getMaterial());
        Assertions.assertEquals(120, reclinerChair.getAngle());
    }

    @Test
    public void testConstructorWithInvalidAngle() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ReclinerChair(200, "Leather", 80));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ReclinerChair(200, "Leather", 160));
    }

    @Test
    public void testAdjustPosition(){
        reclinerChair.adjustPosition(0);
        Assertions.assertEquals(120, reclinerChair.getAngle());
        reclinerChair.adjustPosition(50);
        Assertions.assertEquals(150, reclinerChair.getAngle());
        reclinerChair.adjustPosition(-100);
        Assertions.assertEquals(90, reclinerChair.getAngle());
    }

    @Test
    public void testToString(){
        Assertions.assertEquals("ReclinerChair has an angle of 120 degrees",
                reclinerChair.toString());
    }
}