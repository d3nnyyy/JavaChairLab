package ua.lviv.iot.algo.part1.lab1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class ChairWriter {

    public static final String LINE_SEPARATOR = System.lineSeparator();


    public void writeToFile(final List<Chair> chairs, final String path) throws IOException{
        if (chairs == null || chairs.isEmpty()) {
            return;
        }
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))
                ) {

            chairs.sort(Comparator.comparing((Chair c) -> c.getClass().getSimpleName()));
            Class<?> currentClass = null;

            for (var chair : chairs) {
                Class<?> chairClass = chair.getClass();

                if (chairClass != currentClass) {
                    writer.write(chair.getHeaders() + LINE_SEPARATOR);
                    currentClass = chairClass;
                }

                writer.write(chair.toCSV() + LINE_SEPARATOR);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
