package com.starr.domino.service;


import com.starr.domino.Tile;

import java.util.List;

public interface TileService {

    List<Tile> generateDominoSet(int min, int max);
    List<Tile> getRandomDominoes(List<Tile> set, int count);


}
