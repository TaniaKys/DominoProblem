package com.starr.domino.service;

import com.starr.domino.tile.AbstractTile;
import com.starr.domino.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileServiceImpl implements TileService {


    public List<AbstractTile> generateDominoSet(int min, int max) {
        List<AbstractTile> set = new ArrayList<AbstractTile>();
        for (int left = min; left <= max; left++) {
            for (int right = left; right <= max; right++) {
                set.add(new Tile(left, right));
            }
        }
        return set;
    }

    public List<AbstractTile> getRandomDominoes(List<AbstractTile> set, int count) {
        List<AbstractTile> randSet = new ArrayList<AbstractTile>(set);
        Collections.shuffle(randSet);
        return randSet.subList(0, count);
    }
}
