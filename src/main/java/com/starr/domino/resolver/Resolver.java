package com.starr.domino.resolver;

import com.starr.domino.Tile;

import java.util.List;
import java.util.Set;

public interface Resolver {

    Set<List<Tile>> resolve(List<Tile> list);
}
