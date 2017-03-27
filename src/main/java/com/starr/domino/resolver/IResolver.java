package com.starr.domino.resolver;

import com.starr.domino.tile.AbstractTile;

import java.util.List;

/**
 * Interface for solving domino problem
 *
 * @author Tania Kysla
 */
public interface IResolver {

    /**
     * Resolve domino problem and returns result
     *
     * @param list set of dominoes
     * @return longest domino chain
     */
    List<AbstractTile> resolve(List<AbstractTile> list);
}
