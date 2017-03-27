package com.starr.domino.resolver;

import com.starr.domino.tile.AbstractTile;

import java.util.List;

public interface IResolver {

    List<AbstractTile> resolve(List<AbstractTile> list);
}
