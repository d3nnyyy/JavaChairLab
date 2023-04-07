package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChairTest {
    @Test
    public void testToString() {
        Chair chair = new FeedingTable(40, "Wood", 0.8, 2);
        String expected = "FeedingTable is for 2 years old child and has a height of 0.8 meters";
        assertEquals(expected, chair.toString());
    }

}