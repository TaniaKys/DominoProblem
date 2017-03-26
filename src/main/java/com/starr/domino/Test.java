package com.starr.domino;


import com.starr.domino.resolver.BruteForceResolver;
import com.starr.domino.service.TileService;
import com.starr.domino.service.TileServiceImpl;

import java.util.*;

public class Test {

    static final int MIN = 0;
    static final int MAX = 6;

    //TODO: read from args
    //TODO: check for count (28 allowed)
    public static void main(String[] args) {
        TileService service = new TileServiceImpl();
        List<Tile> tiles = service.generateDominoSet(MIN, MAX);
        System.out.println(tiles);

        ConsoleReader consoleReader = new ConsoleReader();
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
        Set<List<Tile>> result = bruteForceResolver.resolve(testList2);
        System.out.println("RESULT");
        for(List<Tile> list : result){
            System.out.println(list);
        }
    }




}
