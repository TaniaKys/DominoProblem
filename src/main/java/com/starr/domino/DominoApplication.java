package com.starr.domino;


import com.starr.domino.resolver.IResolver;
import com.starr.domino.set.AbstractDominoSet;
import com.starr.domino.set.DominoSet;
import com.starr.domino.tile.AbstractTile;
import com.starr.domino.util.Dots;

import java.util.ArrayList;
import java.util.List;

public class DominoApplication {

    private IResolver resolver;

    public DominoApplication(IResolver resolver) {
        this.resolver = resolver;
    }

    public void run(int count) {
        System.out.println("Running app...");
        AbstractDominoSet dominoSet = new DominoSet(Dots.MIN, Dots.MAX);
        System.out.println(dominoSet);
        List<AbstractTile> randomDominoes = dominoSet.getRandomAmount(count);
        System.out.println("Set: "+randomDominoes);
        List<AbstractTile> result = resolver.resolve(randomDominoes);
        System.out.println("Result: " + result);
        List<AbstractTile> outOfChain = new ArrayList<AbstractTile>();
        for (AbstractTile tile : randomDominoes) {
            if (!result.contains(tile)) {
                outOfChain.add(tile);
            }
        }
        System.out.println("Out of chain: " + outOfChain);
    }


}
