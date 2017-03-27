package com.starr.domino.model;

/**
 * AbstractClass for domino tile models
 *
 * @author Tania Kysla
 */
public abstract class AbstractTile implements Comparable<AbstractTile>{

    /**
     * Enum class which described possible connections ways between domino tiles. States:
     * <br><WITH_FLIP - tiles can be connected if flip one of them
     * <br>WITHOUT_FLIP - tiles can be connected without flipping
     * <br>NONE - tiles cannot be connected
     */
    public enum Connection {
        WITH_FLIP,
        WITHOUT_FLIP,
        NONE
    }

    protected int left;
    protected int right;
    protected boolean isBusy;

    /**
     * Creates domino tile entity
     *
     * @param left  dots value of left side
     * @param right dots value of right side
     */
    public AbstractTile(int left, int right) {
        this.right = right;
        this.left = left;
    }

    /**
     * Checks if domino tiles can be connected.
     *
     * @param other Domino tile which should be connected
     * @return Possible connection state
     */
    public Connection connectedWith(AbstractTile other) {
        if (right == other.getLeft()) {
            return Connection.WITHOUT_FLIP;
        }
        if (right == other.getRight()) {
            return Connection.WITH_FLIP;
        }
        return Connection.NONE;
    }

    /**
     * Flips domino tile (swap left and right sides)
     *
     * @return Return itself
     */
    public AbstractTile flip() {
        int tmp = left;
        left = right;
        right = tmp;
        return this;
    }

    /**
     * Resets domino tile state to default
     */
    public void resetState() {
        isBusy = false;
    }

    /**
     * Makes domino tile entity copy
     *
     * @return new instance of copied domino tile
     */
    public abstract AbstractTile getCopy();

    /**
     * @return dots count from left side
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return dots count from right side
     */
    public int getRight() {
        return right;
    }

    /**
     * @return busy state
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Set busy state
     *
     * @param busy
     */
    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
