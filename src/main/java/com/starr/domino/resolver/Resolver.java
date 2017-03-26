package com.starr.domino.resolver;

import com.starr.domino.tile.Tile;

import java.util.List;

public interface Resolver {

    List<Tile> resolve(List<Tile> list);
}
