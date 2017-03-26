package com.starr.domino.resolver;


import com.starr.domino.tile.Tile;

import java.util.*;

public class BruteForceResolver implements Resolver {

    private List<Tile> origin;
    private List<Tile> temp = new ArrayList<Tile>();
    private List<Tile> result = new ArrayList<Tile>();

    //TODO: delete
    private int iteration = 0;

    public List<Tile> resolve(List<Tile> list) {
        temp.clear();
        result.clear();
        if(list == null){
            return result;
        }
        origin = list;
        for (Tile tile : origin) {
            buildChain(tile);
            buildChain(tile.flip());
        }
        //TODO: delete
        System.out.println(iteration);
        return result;
    }

    private void buildChain(Tile current) {
        current.setBusy(true);
        temp.add(new Tile(current));
        for (Tile tile : origin) {
            if (!tile.isBusy()) {
                Tile.Connection connection = current.connectedWith(tile);
                if (connection.equals(Tile.Connection.WITHOUT_FLIP)) {
                    buildChain(tile);
                } else if (connection.equals(Tile.Connection.WITH_FLIP)) {
                    buildChain(tile.flip());
                }
                iteration++;
            }
        }
        //TODO: delete
        System.out.println(temp);
        if(temp.size() > result.size()){
            result = new ArrayList<Tile>(temp);
        }
        current.setBusy(false);
        temp.remove(current);
    }


}
