package com.starr.domino.service;

import com.starr.domino.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileServiceImpl implements TileService {


    public List<Tile> generateDominoSet(int min, int max) {
        List<Tile> set = new ArrayList<Tile>();
        for (int left = min; left <= max; left++) {
            for (int right = left; right <= max; right++) {
                set.add(new Tile(left, right));
            }
        }
        return set;
    }

    public List<Tile> getRandomDominoes(List<Tile> set, int count) {
        List<Tile> randSet = new ArrayList<Tile>(set);
        Collections.shuffle(randSet);
        return randSet.subList(0, count);
    }
}
