package com.starr.domino.service;


import com.starr.domino.tile.AbstractTile;
import com.starr.domino.tile.Tile;

import java.util.List;

public interface TileService {

    List<AbstractTile> generateDominoSet(int min, int max);
    List<AbstractTile> getRandomDominoes(List<AbstractTile> set, int count);


}
