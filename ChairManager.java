package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter

public class ChairManager extends AddChair{

    private static final List<Chair> chairs = new ArrayList<>();

    @Override
    List<Chair> findChairsByMaterial(String material) {
        return chairs
                .stream()
                .filter(i -> i.getMaterial() == material)
                .toList();
    }

    @Override
    List<Chair> findChairsWithMaxWeightMoreThan(int maxWeight) {
        return chairs
                .stream()
                .filter(i -> i.getMaxWeight() > maxWeight)
                .toList();
    }

    void addChair(final Chair chair){
        chairs.add(chair);
    }

    public static void main(String[] args){

        ChairManager chairManager = new ChairManager();


        Chair feedingTable1 = new FeedingTable(40, "Wood", 0.8,2);
        Chair feedingTable2 = new FeedingTable(20, "Plastic", 0.6, 3);

        Chair officeChair1 = new OfficeChair(150, "Steel", 100);
        Chair officeChair2 = new OfficeChair(130,  "Leather", 90);

        Chair gamingChair1 = new GamingChair(120, "Plastic", 1.5, true);
        Chair gamingChair2 = new GamingChair(140, "Metal", 1.6, true);

        Chair reclinerChair1 = new ReclinerChair(200, "Leather", 120);
        Chair reclinerChair2 = new ReclinerChair(180, "Fabric", 100);

        chairManager.addChair(feedingTable1);
        chairManager.addChair(feedingTable2);
        chairManager.addChair(officeChair1);
        chairManager.addChair(officeChair2);
        chairManager.addChair(gamingChair1);
        chairManager.addChair(gamingChair2);
        chairManager.addChair(reclinerChair1);

        chairManager.addChair(reclinerChair2);
//
//        for (Chair chair : chairs){
//            System.out.println(chair);
//        }

        List<Chair> chairsWithCertainMaterial = chairManager.findChairsByMaterial("Leather");
        chairsWithCertainMaterial.stream().forEach(s -> System.out.println(s));

        List<Chair> chairsWithCertainMaxWeight = chairManager.findChairsWithMaxWeightMoreThan(120);
        chairsWithCertainMaxWeight.stream().forEach(s -> System.out.println(s));

    }
}
