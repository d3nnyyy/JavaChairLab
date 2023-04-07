package ua.lviv.iot.algo.part1.lab1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChairManagerTest {

    private ChairManager manager;

    @Before
    public void setUp() {
        manager = new ChairManager();
        List<Chair> chairs = new ArrayList<>();

        chairs.add(new FeedingTable(40, "Wood", 0.8, 2));
        chairs.add(new FeedingTable(20, "Plastic", 0.6, 3));
        chairs.add(new OfficeChair(150, "Steel", 100));
        chairs.add(new OfficeChair(130, "Leather", 90));
        chairs.add(new GamingChair(120, "Plastic", 1.5, true));
        chairs.add(new GamingChair(140, "Metal", 1.6, true));
        chairs.add(new ReclinerChair(200, "Leather", 120));
        chairs.add(new ReclinerChair(180, "Fabric", 100));

        for (Chair chair : chairs) {
            manager.addChair(chair);
        }
    }

    @Test
    public void testFindChairsByMaterial() {
        List<Chair> chairsWithCertainMaterial = manager.findChairsByMaterial("Leather");
        assertEquals(2, chairsWithCertainMaterial.size());
        assertTrue(chairsWithCertainMaterial.stream().allMatch(chair -> Objects.equals(chair.getMaterial(), "Leather")));
    }

    @Test
    public void testFindChairsWithMaxWeightMoreThan() {
        List<Chair> chairsWithCertainMaxWeight = manager.findChairsWithMaxWeightMoreThan(180);
        assertEquals(2, chairsWithCertainMaxWeight.size());
        assertTrue(chairsWithCertainMaxWeight.stream().allMatch(chair -> chair.getMaxWeight() > 180));
    }
}
