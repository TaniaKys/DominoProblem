package com.starr.domino;


import java.util.*;

public class DominoMatrix {

    int[][] matrix;
    int size;

    Map<Integer, Set<Integer>> map;

    public DominoMatrix(int min, int max) {
        size = max - min + 1;
        this.matrix = new int[size][size];

        map = new HashMap<Integer, Set<Integer>>(size);
        for (int i = 0; i < size; i++) {
            map.put(i, new HashSet<Integer>());
        }
    }


    //-- adjacency matrix --
    public void fillMatrix(List<Tile> list) {
        for (Tile tile : list) {
            matrix[tile.getLeft()][tile.getRight()] = 1;
            matrix[tile.getRight()][tile.getLeft()] = 1;
        }
    }

    public void printMatrix() {
        //TODO: need to use printf and toString
        System.out.println("-- adjacency matrix --");

        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | ");
            for (int y = 0; y < size; y++) {
                System.out.print(matrix[i][y] + " ");
            }
            System.out.println();
        }
    }


    //-- adjacency list --

    public void fillList(List<Tile> list) {
        for (Tile tile : list) {
            map.get(tile.getLeft()).add(tile.getRight());
            map.get(tile.getRight()).add(tile.getLeft());
        }
    }

    public Map<Integer, Set<Integer>> getMap() {
        return map;
    }
}
