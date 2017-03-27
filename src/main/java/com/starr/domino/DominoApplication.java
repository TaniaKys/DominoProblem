package com.starr.domino;


import com.starr.domino.resolver.IResolver;
import com.starr.domino.model.AbstractDominoSet;
import com.starr.domino.model.DominoSet;
import com.starr.domino.model.AbstractTile;
import com.starr.domino.util.DominoConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Main application for solving domino problem
 */
public class DominoApplication {

    private IResolver resolver;

    /**
     * Creates domino application
     *
     * @param resolver domino problem resolver
     */
    public DominoApplication(IResolver resolver) {
        this.resolver = resolver;
    }

    /**
     * Running application
     *
     * @param count dominoes count
     */
    public void run(int count) {
        System.out.println("Running app...");
        AbstractDominoSet dominoSet = new DominoSet(DominoConfig.MIN, DominoConfig.MAX);
        System.out.println(dominoSet);
        List<AbstractTile> randomDominoes = dominoSet.getRandomAmount(count);
        System.out.println("Set: " + randomDominoes);
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
