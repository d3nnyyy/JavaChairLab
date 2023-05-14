package ua.lviv.iot.algo.part1.lab1;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GamingChairTest {

    GamingChair gamingChair = new GamingChair(120, "Plastic", 1.5, true);

    @Test
    public void testConstructor() {
        Assertions.assertEquals(120, gamingChair.getMaxWeight());
        Assertions.assertEquals("Plastic", gamingChair.getMaterial());
        Assertions.assertEquals(1.5, gamingChair.getHeight());
        Assertions.assertTrue(gamingChair.isHasFootrest());
    }

    @Test
    public void testConstructorWithInvalidHeight() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GamingChair(120, "Plastic", 5, true));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GamingChair(120, "Plastic", 2, true));
    }

    @Test
    public void testAdjustPosition() {
        gamingChair.adjustPosition(0);
        Assertions.assertEquals(1.5, gamingChair.getHeight());
        gamingChair.adjustPosition(1);
        Assertions.assertEquals(GamingChair.MAX_HEIGHT, gamingChair.getHeight());
        gamingChair.adjustPosition(-2);
        Assertions.assertEquals(GamingChair.MIN_HEIGHT, gamingChair.getHeight());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("GamingChair has a height of 1.5 meters and has a footrest.",
                gamingChair.toString());
    }
}