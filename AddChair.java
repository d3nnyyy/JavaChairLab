package ua.lviv.iot.algo.part1.lab1;

import java.util.List;

public abstract class AddChair {

    abstract List<Chair> findChairsByMaterial(String material);

    abstract List<Chair> findChairsWithMaxWeightMoreThan(int maxWeight);

    abstract void addChair(final Chair chair);
}
