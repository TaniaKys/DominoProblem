package com.starr.domino.set;


import com.starr.domino.tile.AbstractTile;
import com.starr.domino.tile.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for storage domino set
 *
 * @author Tania Kysla
 */
public class DominoSet extends AbstractDominoSet {

    /**
     * Creates domino tiles set
     *
     * @param min minimal value of dots
     * @param max maximal value of dots
     */
    public DominoSet(int min, int max) {
        set = generateSet(min, max);
    }

    protected List<AbstractTile> generateSet(int min, int max) {
        List<AbstractTile> set = new ArrayList<AbstractTile>();
        for (int left = min; left <= max; left++) {
            for (int right = left; right <= max; right++) {
                set.add(new Tile(left, right));
            }
        }
        return set;
    }

    public List<AbstractTile> getRandomAmount(int count) {
        List<AbstractTile> randSet = new ArrayList<AbstractTile>(set);
        Collections.shuffle(randSet);
        return randSet.subList(0, count);
    }

    /**
     * @return size of set
     */
    public int getSize() {
        return set.size();
    }

    @Override
    public String toString() {
        return "DominoSet{" +
                set +
                '}';
    }
}
