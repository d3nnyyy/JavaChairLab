package ua.lviv.iot.algo.part1.lab1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class ChairWriter {

    public void writeToFile(final List<Chair> chairs, final String path) {
        if (chairs == null || chairs.isEmpty()) {
            return;
        }
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))
                ) {

            chairs.sort(Comparator.comparing((Chair c) -> c.getClass().getSimpleName()));
            Class<?> currentClass = null;

            String lineSeparator = System.lineSeparator();

            for (int i = 0; i < chairs.size(); i++) {
                Chair chair = chairs.get(i);
                Class<?> chairClass = chair.getClass();

                if (chairClass != currentClass) {
                    writer.write(chair.getHeaders() + lineSeparator);
                    currentClass = chairClass;
                }

                writer.write(chair.toCSV() + lineSeparator);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
