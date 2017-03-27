package com.starr.domino.set;

import com.starr.domino.tile.AbstractTile;

import java.util.List;

public abstract class AbstractDominoSet {

    protected List<AbstractTile> set;

    protected abstract List<AbstractTile> generateSet(int min, int max);

    public abstract List<AbstractTile> getRandomAmount(int count);
}
