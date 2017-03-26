package com.starr.domino.resolver;

import com.starr.domino.tile.AbstractTile;
import com.starr.domino.tile.Tile;

import java.util.List;
import java.util.Set;

public interface Resolver {

    Set<List<AbstractTile>> resolve(List<AbstractTile> list);
}
