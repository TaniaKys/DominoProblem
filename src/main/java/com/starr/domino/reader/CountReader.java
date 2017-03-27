package com.starr.domino.reader;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class for reading domino counts from program argument or (if argument is invalid or not exist) via command line interface
 *
 * @author Tania Kysla
 */
public class CountReader implements ICountReader {

    private class InvalidRangeException extends Exception {
        InvalidRangeException() {
            super("Number must be in range [1, " + maxCount + "]");
        }
    }

    private BufferedReader consoleReader;
    private int maxCount;
    private String[] args;

    /**
     * Creates program arguments reader (if arguments are invalid - uses command line)
     *
     * @param args
     */
    public CountReader(String[] args) {
        this.args = args;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private int readCountFromConsole() {
        int count;
        System.out.println("Enter number of dominoes: ");
        try {
            count = Integer.parseInt(consoleReader.readLine().trim());
            if (!isOutOfRange(count)) {
                throw new InvalidRangeException();
            }
        } catch (Exception e) {
            System.out.println(e.toString() + ". Try again.");
            count = readCountFromConsole();
        }
        return count;
    }

    public int readCount(int countLimit) {
        maxCount = countLimit;
        int count;
        try {
            count = Integer.parseInt(args[0].trim());
            if (!isOutOfRange(count)) {
                throw new InvalidRangeException();
            }
            System.out.println("Number of dominoes: " + count);
        } catch (Exception e) {
            System.out.println("Argument parameter is invalid or missing. Console interface is running...");
            count = readCountFromConsole();
        }
        return count;
    }

    private boolean isOutOfRange(int count) {
        return count > 0 || count <= maxCount;
    }
}
