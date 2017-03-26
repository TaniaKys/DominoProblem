package com.starr.domino.test;


import com.starr.domino.CountReader;
import com.starr.domino.xtrash.DominoMatrix;
import com.starr.domino.resolver.BruteForceResolver;
import com.starr.domino.set.DominoSet;
import com.starr.domino.tile.Tile;

import java.util.*;

public class Test {

    static final int MIN = 0;
    static final int MAX = 6;

    //TODO: read from args
    //TODO: check for count (28 allowed)
    public static void main(String[] args) {
        DominoSet dominoSet = new DominoSet(MIN, MAX);
        System.out.println(dominoSet);

        //CountReader consoleReader = new CountReader();
        //int count = consoleReader.readCount();


       // List<Tile> randomDominoes = service.getRandomDominoes(tiles, count);
        //System.out.println(randomDominoes);

        DominoMatrix matrix = new DominoMatrix(MIN, MAX);
        //matrix.fillMatrix(randomDominoes);
        //matrix.printMatrix();

        //matrix.fillList(randomDominoes);
        //System.out.println(matrix.getMap());


        List<Tile> testList = new ArrayList<Tile>();
        testList.add(new Tile(2, 4));
        testList.add(new Tile(5, 6));
        testList.add(new Tile(2, 5));
        testList.add(new Tile(1, 6));
        testList.add(new Tile(6, 6));

        //System.out.println(testList);

        List<Tile> testList2 = new ArrayList<Tile>();
        testList2.add(new Tile(1, 2));
        testList2.add(new Tile(2, 3));
        testList2.add(new Tile(1, 3));

        System.out.println(testList2);

        BruteForceResolver bruteForceResolver = new BruteForceResolver();
        List<Tile> result = bruteForceResolver.resolve(testList2);
        System.out.println("RESULT");
        System.out.println(result);
    }




}
