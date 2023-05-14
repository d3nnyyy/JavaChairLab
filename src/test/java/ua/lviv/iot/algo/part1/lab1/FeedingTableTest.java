package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FeedingTableTest {
    FeedingTable feedingTable = new FeedingTable(40, "Wood", 0.8, 2);

    @Test
    public void testConstructor() {
        Assertions.assertEquals(40, feedingTable.getMaxWeight());
        Assertions.assertEquals("Wood", feedingTable.getMaterial());
        Assertions.assertEquals(0.8, feedingTable.getHeight());
        Assertions.assertEquals(2, feedingTable.getChildAge());
    }

    @Test
    public void testConstructorWithInvalidHeight() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedingTable(40, "Wood", 2, 2));
    }

    @Test
    public void testGetHeaders(){
        Assertions.assertEquals(
                "maxWeight, material, MIN_HEIGHT, MAX_HEIGHT, height, childAge", feedingTable.getHeaders()
        );
    }

    @Test
    public void testToCSV(){
        Assertions.assertEquals(
                "40, Wood, 0.5, 1.0, 0.8, 2", feedingTable.toCSV()
        );
    }

    @Test
    public void testAdjustPosition() {
        feedingTable.adjustPosition(0);
        Assertions.assertEquals(0.8, feedingTable.getHeight());
        feedingTable.adjustPosition(1);
        Assertions.assertEquals(FeedingTable.MAX_HEIGHT, feedingTable.getHeight());
        feedingTable.adjustPosition(-2);
        Assertions.assertEquals(FeedingTable.MIN_HEIGHT, feedingTable.getHeight());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("FeedingTable is for 2 years old child and has a height of 0.8 meters",
                feedingTable.toString());
    }
}