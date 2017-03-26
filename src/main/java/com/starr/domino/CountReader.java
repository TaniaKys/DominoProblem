package com.starr.domino;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountReader {

    BufferedReader consoleReader;

    public CountReader() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readCountFromConsole(){
        int count;
        System.out.println("Enter number of dominoes: ");
        try {
           count = Integer.parseInt(consoleReader.readLine());
        } catch (Exception e) {
            System.out.println(e.toString()+". Try again.");
            count = readCountFromConsole();
        }
        return count;
    }

    public int readCount(String arg){
        int count;
        try {
            count = Integer.parseInt(arg);
        } catch (Exception e) {
            System.out.println(e.toString()+". Invalid arg parameter. Console interface is running...");
            count = readCountFromConsole();
        }
        return count;
    }

}
