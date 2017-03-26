package com.starr.domino.resolver;


import com.starr.domino.Tile;

import java.util.*;

public class BruteForceResolver implements Resolver {

    private List<Tile> temp = new ArrayList<Tile>();
    private List<Tile> origin;
    private Set<List<Tile>> result = new HashSet<List<Tile>>();

    private int iteration = 0;
    private int longestSize = 0;

    public Set<List<Tile>> resolve(List<Tile> list) {
        // TODO: check for null
        origin = list;
        for (Tile tile : origin) {
            buildChain(tile);
            buildChain(tile.flip());
        }
        System.out.println(iteration);
        return result;
    }

    private void buildChain(Tile current) {
        current.setBusy(true);
        temp.add(current);
        for (Tile tile : origin) {
            if (!tile.isBusy()) {
                int suits = current.isSuits(tile);
                if (suits == 1) {
                    buildChain(tile);
                } else if (suits == 2) {
                    buildChain(tile.flip());
                }
                iteration++;
            }
        }
        current.resetState();
         System.out.println(temp);
        if(temp.size() == origin.size()){
            result.add(new ArrayList<Tile>(temp));
        }

        temp.remove(current);
    }


}
