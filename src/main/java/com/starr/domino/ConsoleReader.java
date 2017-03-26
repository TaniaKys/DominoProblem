package com.starr.domino;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {

    BufferedReader reader;

    public ConsoleReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readCount(){
        int count = 0;
        System.out.println("Enter number of dominoes: ");
        try {
           count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(e.toString()+". Try again.");
            readCount();
        }
        return count;
    }

}
