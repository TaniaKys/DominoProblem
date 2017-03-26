package com.starr.domino;


import com.starr.domino.util.Dots;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountReader {

    private class InvalidRangeException extends Exception {
        public InvalidRangeException() {
            super("Number must be in range [1, " + maxCount+"]");
        }
    }

    private BufferedReader consoleReader;
    private int maxCount;

    public CountReader() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        maxCount = calculateMaxCount();
    }

    private int readCountFromConsole() {
        int count;
        System.out.println("Enter number of dominoes: ");
        try {
            count = Integer.parseInt(consoleReader.readLine());
            if(!inRange(count)){
                throw new InvalidRangeException();
            }
        } catch (Exception e) {
            System.out.println(e.toString() + ". Try again.");
            count = readCountFromConsole();
        }
        return count;
    }

    public int readCount(String[] arg) {
        int count;
        try {
            count = Integer.parseInt(arg[0]);
            if(!inRange(count)){
                throw new InvalidRangeException();
            }
            System.out.println("Number of dominoes: " + count);
        } catch (Exception e) {
            System.out.println("Argument parameter is invalid or missing. Console interface is running...");
            count = readCountFromConsole();
        }
        return count;
    }

    private int calculateMaxCount() {
        int max = Dots.MAX - Dots.MIN;
        return ((max * max + (3 * max) + 2) / 2);
    }

    private boolean inRange(int count){
        return count > 0 || count <= maxCount;
    }
}
