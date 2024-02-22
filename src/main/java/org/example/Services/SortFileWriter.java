package org.example.Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SortFileWriter {
    public static void writeToFile(List<String> list, String outputPath, String filename) {
        if (!list.isEmpty()) {
            File outputFile = new File(outputPath, filename);

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                for (String item : list) {
                    writer.println(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addToFile(List<String> list, String outputPath, String filename) {
        if (!list.isEmpty()) {
            File outputFile = new File(outputPath, filename);

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true))) {
                for (String item : list) {
                    writer.println(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sortAddToFile(String outputPath, String prefix) {
        addWriteIntegersToFile(outputPath, "integers.txt", prefix);
        addWriteStringsToFile(outputPath, "strings.txt", prefix);
        addWriteDoublesToFile(outputPath, "floats.txt", prefix);
    }



    public static void sortWriteToFile(String outputPath, String prefix) {
        if (isValidOutputPath(outputPath)) {
            writeIntegersToFile(outputPath, "integers.txt", prefix);
            writeStringsToFile(outputPath, "strings.txt", prefix);
            writeDoublesToFile(outputPath, "floats.txt", prefix);
        } else {
            System.err.println("Некорректный путь для результатов: " + outputPath);
        }
    }

    public static void addWriteIntegersToFile(String outputPath, String filename, String prefix) {
        List<String> integerList = FileSeparator.getIntegerList();
        if (!integerList.isEmpty()) {
            String fullFilename = prefix + filename;
            addToFile(integerList, outputPath, fullFilename);
        }
    }

    public static void addWriteDoublesToFile(String outputPath, String filename, String prefix) {
        List<String> doubleList = FileSeparator.getDoubleList();
        if (!doubleList.isEmpty()) {
            String fullFilename = prefix + filename;
            addToFile(doubleList, outputPath, fullFilename);
        }
    }

    public static void addWriteStringsToFile(String outputPath, String filename, String prefix) {
        List<String> stringList = FileSeparator.getStringList();
        if (!stringList.isEmpty()) {
            String fullFilename = prefix + filename;
            addToFile(stringList, outputPath, fullFilename);
        }
    }

    public static void writeIntegersToFile(String outputPath, String filename, String prefix) {
        List<String> integerList = FileSeparator.getIntegerList();
        if (!integerList.isEmpty()) {
            String fullFilename = prefix + filename;
            writeToFile(integerList, outputPath, fullFilename);
        }
    }

    public static void writeDoublesToFile(String outputPath, String filename, String prefix) {
        List<String> doubleList = FileSeparator.getDoubleList();
        if (!doubleList.isEmpty()) {
            String fullFilename = prefix + filename;
            writeToFile(doubleList, outputPath, fullFilename);
        }
    }

    public static void writeStringsToFile(String outputPath, String filename, String prefix) {
        List<String> stringList = FileSeparator.getStringList();
        if (!stringList.isEmpty()) {
            String fullFilename = prefix + filename;
            writeToFile(stringList, outputPath, fullFilename);
        }
    }

    private static boolean isValidOutputPath(String outputPath) {
        return !outputPath.isEmpty() && Files.exists(Paths.get(outputPath));
    }
}