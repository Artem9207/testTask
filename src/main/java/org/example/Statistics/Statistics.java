package org.example.Statistics;

public class Statistics {
    private int integersCount;
    private int floatsCount;
    private int stringsCount;
    private int minInteger;
    private int maxInteger;
    private int sumInteger;
    private double averageInteger;
    private float minFloat;
    private float maxFloat;
    private float sumFloat;
    private float averageFloat;
    private String shortestString;

    public int getIntegersCount() {
        return integersCount;
    }

    public void setIntegersCount(int integersCount) {
        this.integersCount = integersCount;
    }

    public int getFloatsCount() {
        return floatsCount;
    }

    public void setFloatsCount(int floatsCount) {
        this.floatsCount = floatsCount;
    }

    public int getStringsCount() {
        return stringsCount;
    }

    public void setStringsCount(int stringsCount) {
        this.stringsCount = stringsCount;
    }

    public int getMinInteger() {
        return minInteger;
    }

    public void setMinInteger(int minInteger) {
        this.minInteger = minInteger;
    }

    public int getMaxInteger() {
        return maxInteger;
    }

    public void setMaxInteger(int maxInteger) {
        this.maxInteger = maxInteger;
    }

    public int getSumInteger() {
        return sumInteger;
    }

    public void setSumInteger(int sumInteger) {
        this.sumInteger = sumInteger;
    }

    public double getAverageInteger() {
        return averageInteger;
    }

    public void setAverageInteger(double averageInteger) {
        this.averageInteger = averageInteger;
    }

    public float getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(float minFloat) {
        this.minFloat = minFloat;
    }

    public float getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(float maxFloat) {
        this.maxFloat = maxFloat;
    }

    public float getSumFloat() {
        return sumFloat;
    }

    public void setSumFloat(float sumFloat) {
        this.sumFloat = sumFloat;
    }

    public float getAverageFloat() {
        return averageFloat;
    }

    public void setAverageFloat(float averageFloat) {
        this.averageFloat = averageFloat;
    }

    public String getShortestString() {
        return shortestString;
    }

    public void setShortestString(String shortestString) {
        this.shortestString = shortestString;
    }

    public String getLongestString() {
        return longestString;
    }

    public void setLongestString(String longestString) {
        this.longestString = longestString;
    }

    private String longestString;

    public Statistics() {
        integersCount = 0;
        floatsCount = 0;
        stringsCount = 0;
        minInteger = Integer.MAX_VALUE;
        maxInteger = Integer.MIN_VALUE;
        sumInteger = 0;
        averageInteger = 0.0;
        minFloat = Float.MAX_VALUE;
        maxFloat = Float.MIN_VALUE;
        sumFloat = 0.0f;
        averageFloat = 0.0f;
        shortestString = null;
        longestString = null;
    }
}
