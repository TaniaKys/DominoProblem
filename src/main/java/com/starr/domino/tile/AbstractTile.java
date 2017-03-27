package com.starr.domino.tile;


public abstract class AbstractTile {

    public enum Connection {
        WITH_FLIP,
        WITHOUT_FLIP,
        NONE
    }

    protected int left;
    protected int right;
    protected boolean isBusy;

    public AbstractTile(int left, int right) {
        this.right = right;
        this.left = left;
    }

    public Connection connectedWith(AbstractTile other) {
        if (right == other.getLeft()) {
            return Connection.WITHOUT_FLIP;
        }
        if (right == other.getRight()) {
            return Connection.WITH_FLIP;
        }
        return Connection.NONE;
    }

    public AbstractTile flip(){
        int tmp = left;
        left = right;
        right = tmp;
        return this;
    }

    public void resetState(){
        isBusy = false;
    }

    public abstract AbstractTile getCopy();

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
