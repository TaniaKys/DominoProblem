package com.starr.domino.model;

/**
 * Class for reading domino counts from program argument or (if argument is invalid or not exist) via command line interface
 *
 * @author Tania Kysla
 */
public class Tile extends AbstractTile implements Comparable<Tile> {

    private boolean isFlipped;

    /**
     * Creates domino tile entity. Left side is always lower or equals to right side
     *
     * @param left  dots value of left side
     * @param right dots value of right side
     */
    public Tile(int left, int right) {
        super(left, right);
        if (this.left > this.right) {
            int tmp = this.left;
            this.left = this.right;
            this.right = tmp;
        }
    }


    /**
     * Private copy constructor
     *
     * @param tile Domino tile entity
     */
    private Tile(Tile tile) {
        super(tile.left, tile.right);
        this.isFlipped = tile.isFlipped;
    }

    /**
     * @return flipped state
     */
    public boolean isFlipped() {
        return isFlipped;
    }

    @Override
    public Tile flip() {
        super.flip();
        isFlipped = !isFlipped;
        return this;
    }

    @Override
    public void resetState() {
        super.resetState();
        if (left > right) {
            int tmp = left;
            left = right;
            right = tmp;
        }
        isFlipped = false;
    }

    public Tile getCopy() {
        return new Tile(this);
    }

    public int compareTo(Tile o) {
        if (left > o.left) {
            return 1;
        }
        if (left < o.left) {
            return -1;
        }
        if (right > o.right) {
            return 1;
        }
        if (right < o.right) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return right == tile.right && left == tile.left || (right == tile.left && left == tile.right);
    }

    @Override
    public int hashCode() {
        return 31 * left + 31 * right;
    }

    @Override
    public String toString() {
        return "[" + left + "|" + right + "]";
    }
}
