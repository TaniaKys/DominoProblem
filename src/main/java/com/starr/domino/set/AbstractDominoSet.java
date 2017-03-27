package com.starr.domino.set;

import com.starr.domino.tile.AbstractTile;

import java.util.List;

/**
 * AbstractClass for domino set models
 *
 * @author Tania Kysla
 */
public abstract class AbstractDominoSet {

    protected List<AbstractTile> set;

    /**
     * Generate set of domino tiles
     *
     * @param min minimal value of dots
     * @param max maximal value of dots
     * @return set of tiles
     */
    protected abstract List<AbstractTile> generateSet(int min, int max);

    /**
     * Returns random tiles from tiles set
     *
     * @param count number of tiles
     * @return set of tiles
     */
    public abstract List<AbstractTile> getRandomAmount(int count);
}
