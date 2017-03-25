package com.starr.domino;



import java.util.HashSet;
import java.util.Set;

public class Test {

    static final int MIN = 0;
    static final int MAX = 6;

    public static void main(String[] args) {
        Set<Tile> tiles = generateDominoSet();
        printDominoSet(tiles);
        System.out.println(tiles.size());
    }

   static Set<Tile> generateDominoSet() {
        Set<Tile> set = new HashSet<Tile>();
        for (int left = MIN; left <= MAX; left++) {
            for (int right = MIN; right <= MAX; right++) {
                set.add(new Tile(left, right));
            }
        }
        return set;
    }

    static void printDominoSet(Set<Tile> set) {
        for (Tile tile : set) {
            System.out.print(tile + " ");
        }
    }
}
