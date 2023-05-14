package ua.lviv.iot.algo.part1.lab1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;

import ua.lviv.iot.algo.part1.lab1.models.Chair;
import ua.lviv.iot.algo.part1.lab1.models.FeedingTable;
import ua.lviv.iot.algo.part1.lab1.writer.ChairWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class ChairWriterTest {
    private ChairWriter writer;
    private static String RESULT_FILENAME = "result.csv";
    private static String EXPECTED_FILENAME = "expected.csv";
    private List<Chair> chairs;

    @Before
    public void setUp() throws IOException {
        writer = new ChairWriter();
        Files.deleteIfExists(Path.of(RESULT_FILENAME));
        chairs = new ArrayList<>();
    }

    @AfterAll
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(RESULT_FILENAME));
    }

    @Test
    public void testEmptyWrite() throws IOException {
        writer.writeToFile(chairs, RESULT_FILENAME);
        File file = new File(RESULT_FILENAME);
        Assertions.assertFalse(file.exists());
    }

    @Test
    public void testWriteListOfChairs() throws IOException {

        chairs.add(new FeedingTable(20, "Plastic", 0.6, 3));
        chairs.add(new FeedingTable(40, "Wood", 0.8, 2));

        writer.writeToFile(chairs, RESULT_FILENAME);
        Path expected = new File(RESULT_FILENAME).toPath();
        Path actual = new File(EXPECTED_FILENAME).toPath();

        List<String> expectedLines = Files.readAllLines(expected);
        List<String> actualLines = Files.readAllLines(actual);

        int linesCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(RESULT_FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of lines in RESULT_FILENAME: " + linesCount);

        linesCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(EXPECTED_FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of lines in EXPECTED_FILENAME: " + linesCount);

        assertEquals(expectedLines, actualLines);
    }

    @Test
    public void testFileOverride() throws IOException {
        writer.writeToFile(new ArrayList<>(), RESULT_FILENAME);
        testEmptyWrite();
    }
}
