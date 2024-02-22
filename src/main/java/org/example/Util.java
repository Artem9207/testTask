package org.example;


import org.apache.commons.cli.*;
import org.example.Services.FileSeparator;
import org.example.Services.SortFileWriter;
import org.example.Statistics.StatisticsCollector;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Util {
    public static void main(String[] args) {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        options.addOption("s", "short", false, "Display short statistics");
        options.addOption("f", "full", false, "Display full statistics");
        options.addOption("a", "append", false, "Append data to existing files");
        options.addOption(Option.builder("o").longOpt("output")
                .desc("Output directory").hasArg().argName("outputPath").build());
        options.addOption(Option.builder("p").longOpt("prefix")
                .desc("Output file name prefix").hasArg().argName("prefix").build());

        try {
            CommandLine cmd = parser.parse(options, args);

            String[] files = cmd.getArgs();
            String outputPath = cmd.getOptionValue("o", "./");
            String prefix = cmd.getOptionValue("p", "");
            boolean appendMode = cmd.hasOption("a");
            boolean shortStats = cmd.hasOption("s");
            boolean fullStats = cmd.hasOption("f");

            StatisticsCollector statisticsCollector = new StatisticsCollector();

            for (String file : files) {
                FileSeparator.processFile(file);
            }

            String currentDirectory = System.getProperty("user.dir");
            if (outputPath.equals("./")) {
                if (appendMode) {
                    SortFileWriter.sortAddToFile(currentDirectory, prefix);
                } else {
                    SortFileWriter.sortWriteToFile(currentDirectory, prefix);
                }
            } else {
                if (appendMode) {
                    SortFileWriter.sortAddToFile(outputPath, prefix);
                } else {
                    SortFileWriter.sortWriteToFile(outputPath, prefix);
                }
            }

            for (String file : files) {
                System.out.println(file);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println();
                } catch (IOException e) {
                    System.err.println("Error reading file: " + file);
                    e.printStackTrace();
                }
            }

            if (shortStats) {
                statisticsCollector.shortStatistics();
            }
            if (fullStats) {
                statisticsCollector.fullStatistics();
            }

        } catch (ParseException e) {
            System.err.println("Error parsing command line options: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar util.jar [options] file1.txt file2.txt ...", options);
            System.exit(1);
        }
    }
}