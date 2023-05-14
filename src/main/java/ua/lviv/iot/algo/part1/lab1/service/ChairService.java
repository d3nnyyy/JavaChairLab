package ua.lviv.iot.algo.part1.lab1.service;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.algo.part1.lab1.models.Chair;
import ua.lviv.iot.algo.part1.lab1.models.FeedingTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope("singleton")
public class ChairService {
    private final Map<Integer, Chair> chairMap = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public List<Chair> getChairs() {
        return new LinkedList<>(chairMap.values());
    }

    public Chair getChairById(Integer id) {
        return chairMap.get(id);
    }

    public Chair createChair(final FeedingTable feedingTable) {
        feedingTable.setId(idCounter.incrementAndGet());
        chairMap.put(feedingTable.getId(), feedingTable);
        return feedingTable;
    }

    public ResponseEntity<Chair> updateChair(final Integer id, final FeedingTable feedingTable) {
        if (chairMap.containsKey(id)) {
            feedingTable.setId(id);
            chairMap.put(id, feedingTable);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Chair> deleteChair(final Integer id) {
        if (chairMap.containsKey(id)) {
            chairMap.remove(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
