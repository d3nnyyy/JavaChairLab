package ua.lviv.iot.algo.part1.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.algo.part1.lab1.models.Chair;
import ua.lviv.iot.algo.part1.lab1.models.FeedingTable;
import ua.lviv.iot.algo.part1.lab1.service.ChairService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/chairs")
public class ChairController {

    private ChairService chairService;

    @Autowired
    public ChairController(ChairService chairService) {
        this.chairService = chairService;
    }

    @GetMapping
    public List<Chair> getChairs() {
        return new LinkedList<>(chairService.getChairs());
    }

    @GetMapping("/{id}")
    public Object getChairById(final @PathVariable("id") Integer id) {
        return chairService.getChairById(id) == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : chairService.getChairById(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Chair createChair(final @RequestBody FeedingTable feedingTable) {
        return chairService.createChair(feedingTable);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Chair> updateChair(final @PathVariable("id") Integer id, final @RequestBody FeedingTable feedingTable) {
        return chairService.updateChair(id, feedingTable);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Chair> deleteChair(final @PathVariable("id") Integer id) {
        return chairService.deleteChair(id);
    }
}
