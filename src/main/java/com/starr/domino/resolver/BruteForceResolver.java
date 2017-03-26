package com.starr.domino.resolver;


import com.starr.domino.tile.AbstractTile;

import java.util.*;

public class BruteForceResolver implements Resolver {

    private List<AbstractTile> temp = new ArrayList<AbstractTile>();
    private List<AbstractTile> origin;
    private Set<List<AbstractTile>> result = new HashSet<List<AbstractTile>>();

    private int iteration = 0;
    private int longestSize = 0;

    public Set<List<AbstractTile>> resolve(List<AbstractTile> list) {
        // TODO: check for null
        origin = list;
        for (AbstractTile tile : origin) {
            buildChain(tile);
            buildChain(tile.flip());
        }
        System.out.println(iteration);
        return result;
    }

    private void buildChain(AbstractTile current) {
        current.setBusy(true);
        temp.add(current);
        for (AbstractTile tile : origin) {
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
        current.setBusy(false);
         System.out.println(temp);
        if(temp.size() == origin.size()){
            result.add(new ArrayList<AbstractTile>(temp));
        }

        temp.remove(current);
    }


}
