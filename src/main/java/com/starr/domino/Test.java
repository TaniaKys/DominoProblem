package com.starr.domino;


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
        int count = consoleReader.readCount();


        List<Tile> randomDominoes = service.getRandomDominoes(tiles, count);
        System.out.println(randomDominoes);

        DominoMatrix matrix = new DominoMatrix(MIN, MAX);
        matrix.fillMatrix(randomDominoes);
        matrix.printMatrix();

        matrix.fillList(randomDominoes);
        System.out.println(matrix.getMap());
    }




}
