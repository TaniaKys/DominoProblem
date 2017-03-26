package com.starr.domino.set;


import com.starr.domino.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoSet {

    private List<Tile> set;

    public DominoSet(int min, int max) {
        set = generateSet(min, max);
    }

    private List<Tile> generateSet(int min, int max) {
        List<Tile> set = new ArrayList<Tile>();
        for (int left = min; left <= max; left++) {
            for (int right = left; right <= max; right++) {
                set.add(new Tile(left, right));
            }
        }
        return set;
    }

    public List<Tile> getRandomDominoes(int count) {
        List<Tile> randSet = new ArrayList<Tile>(set);
        Collections.shuffle(randSet);
        return randSet.subList(0, count);
    }

    @Override
    public String toString() {
        return "DominoSet{" +
                     set +
                '}';
    }
}
