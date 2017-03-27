package com.starr.domino.resolver;


import com.starr.domino.tile.AbstractTile;

import java.util.*;

public class BruteForceResolver implements IResolver {

    private List<AbstractTile> origin;
    private List<AbstractTile> temp = new ArrayList<AbstractTile>();
    private List<AbstractTile> result = new ArrayList<AbstractTile>();

    //TODO: delete
    private int iteration = 0;

    public List<AbstractTile> resolve(List<AbstractTile> list) {
        temp.clear();
        result.clear();
        if(list == null){
            return result;
        }
        origin = list;
        for (AbstractTile tile : origin) {
            buildChain(tile);
            buildChain(tile.flip());
        }
        //TODO: delete
        System.out.println(iteration);
        return result;
    }

    private void buildChain(AbstractTile current) {
        current.setBusy(true);
        temp.add(current.getCopy());
        for (AbstractTile tile : origin) {
            if (!tile.isBusy()) {
                AbstractTile.Connection connection = current.connectedWith(tile);
                if (connection.equals(AbstractTile.Connection.WITHOUT_FLIP)) {
                    buildChain(tile);
                } else if (connection.equals(AbstractTile.Connection.WITH_FLIP)) {
                    buildChain(tile.flip());
                }
                iteration++;
            }
        }
        //TODO: delete
        System.out.println(temp);
        if(temp.size() > result.size()){
            result = new ArrayList<AbstractTile>(temp);
        }
        current.setBusy(false);
        temp.remove(current);
    }


}
