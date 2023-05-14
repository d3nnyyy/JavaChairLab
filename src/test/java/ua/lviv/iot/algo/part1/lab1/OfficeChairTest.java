package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OfficeChairTest {

    OfficeChair officeChair = new OfficeChair(150, "Steel", 100);

    @Test
    public void testConstructor() {
        Assertions.assertEquals(150, officeChair.getMaxWeight());
        Assertions.assertEquals("Steel", officeChair.getMaterial());
        Assertions.assertEquals(100, officeChair.getAngle());
    }

    @Test
    public void testConstructorWithInvalidAngle() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OfficeChair(150, "Steel", 80));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new OfficeChair(150, "Steel", 170));
    }

    @Test
    public void testAdjustPosition() {
        officeChair.adjustPosition(0);
        Assertions.assertEquals(100, officeChair.getAngle());

        officeChair.adjustPosition(100);
        Assertions.assertEquals(OfficeChair.MAX_ANGLE, officeChair.getAngle());

        officeChair.adjustPosition(-100);
        Assertions.assertEquals(OfficeChair.MIN_ANGLE, officeChair.getAngle());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("OfficeChair has an angle of 100degrees", officeChair.toString());
    }
}