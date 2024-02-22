package org.example.Statistics;

import org.example.Services.FileSeparator;

import java.util.List;

public class StatisticsCollector {
    private Statistics statistics;

    public StatisticsCollector() {
        this.statistics = new Statistics();
    }

    public void shortStatistics() {
        List<String> integerList = FileSeparator.getIntegerList();
        List<String> doubleList = FileSeparator.getDoubleList();
        List<String> stringList = FileSeparator.getStringList();

        statistics.setIntegersCount(integerList.size());
        statistics.setFloatsCount(doubleList.size());
        statistics.setStringsCount(stringList.size());

        System.out.println("Short Statistics:");
        if (!integerList.isEmpty()) {
            System.out.println("Integers count: " + statistics.getIntegersCount());
        }
        if (!doubleList.isEmpty()) {
            System.out.println("Floats count: " + statistics.getFloatsCount());
        }
        if (!stringList.isEmpty()) {
            System.out.println("Strings count: " + statistics.getStringsCount());
        }
    }

    public void fullStatistics() {
        List<String> integerList = FileSeparator.getIntegerList();
        List<String> doubleList = FileSeparator.getDoubleList();
        List<String> stringList = FileSeparator.getStringList();

        statistics.setIntegersCount(integerList.size());
        statistics.setFloatsCount(doubleList.size());
        statistics.setStringsCount(stringList.size());

        if (!integerList.isEmpty()) {
            int minInteger = Integer.MAX_VALUE;
            int maxInteger = Integer.MIN_VALUE;
            int sumInteger = 0;
            double averageInteger = 0.0;

            for (String str : integerList) {
                int value = Integer.parseInt(str);
                minInteger = Math.min(minInteger, value);
                maxInteger = Math.max(maxInteger, value);
                sumInteger += value;
            }

            averageInteger = (double) sumInteger / integerList.size();

            statistics.setMinInteger(minInteger);
            statistics.setMaxInteger(maxInteger);
            statistics.setSumInteger(sumInteger);
            statistics.setAverageInteger(averageInteger);
        }

        if (!doubleList.isEmpty()) {
            float minFloat = Float.MAX_VALUE;
            float maxFloat = Float.MIN_VALUE;
            float sumFloat = 0.0f;
            float averageFloat = 0.0f;

            for (String str : doubleList) {
                float value = Float.parseFloat(str);
                minFloat = Math.min(minFloat, value);
                maxFloat = Math.max(maxFloat, value);
                sumFloat += value;
            }

            averageFloat = sumFloat / doubleList.size();

            statistics.setMinFloat(minFloat);
            statistics.setMaxFloat(maxFloat);
            statistics.setSumFloat(sumFloat);
            statistics.setAverageFloat(averageFloat);
        }

        if (!stringList.isEmpty()) {
            String shortestString = stringList.get(0);
            String longestString = stringList.get(0);

            for (String str : stringList) {
                if (str.length() < shortestString.length()) {
                    shortestString = str;
                }
                if (str.length() > longestString.length()) {
                    longestString = str;
                }
            }

            statistics.setShortestString(shortestString);
            statistics.setLongestString(longestString);
        }

        System.out.println("Full Statistics:");
        if (!integerList.isEmpty()) {
            System.out.println("Integers count: " + statistics.getIntegersCount());
            System.out.println("Min integer: " + statistics.getMinInteger());
            System.out.println("Max integer: " + statistics.getMaxInteger());
            System.out.println("Sum integer: " + statistics.getSumInteger());
            System.out.println("Average integer: " + statistics.getAverageInteger());
        }
        if (!doubleList.isEmpty()) {
            System.out.println("Floats count: " + statistics.getFloatsCount());
            System.out.println("Min float: " + statistics.getMinFloat());
            System.out.println("Max float: " + statistics.getMaxFloat());
            System.out.println("Sum float: " + statistics.getSumFloat());
            System.out.println("Average float: " + statistics.getAverageFloat());
        }
        if (!stringList.isEmpty()) {
            System.out.println("Strings count: " + statistics.getStringsCount());
            System.out.println("Shortest string: " + statistics.getShortestString());
            System.out.println("Longest string: " + statistics.getLongestString());
        }
    }
}
