package edu.ccrm.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private static final String DEFAULT_SEPARATOR = ",";

    public List<String[]> parse(Path csvFile) throws IOException {
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = parseLine(line, DEFAULT_SEPARATOR);
                rows.add(columns);
            }
        }
        return rows;
    }

    private String[] parseLine(String line, String separator) {
        // Simple split by separator; can be improved for quoted commas etc.
        return line.split(separator);
    }
}
