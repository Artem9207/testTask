package org.example.Services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileSeparator {
    private static List<String> integerList = new ArrayList<>();
    private static List<String> doubleList = new ArrayList<>();
    private static List<String> stringList = new ArrayList<>();
    public static void processFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int integerValue = Integer.parseInt(line.trim());
                    integerList.add(String.valueOf(integerValue));
                } catch (NumberFormatException e1) {
                    try {
                        double doubleValue = Double.parseDouble(line.trim());
                        doubleList.add(String.valueOf(doubleValue));
                    } catch (NumberFormatException e2) {
                        stringList.add(line.trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getIntegerList() {
        return integerList;
    }

    public static List<String> getDoubleList() {
        return doubleList;
    }

    public static List<String> getStringList() {
        return stringList;
    }
}
