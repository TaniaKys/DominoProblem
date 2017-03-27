package com.starr.domino.tile;

public class Tile extends AbstractTile implements Comparable<Tile> {

    private boolean isFlipped;

    public Tile(int left, int right) {
        super(left, right);
        if (this.left > this.right) {
            int tmp = this.left;
            this.left = this.right;
            this.right = tmp;
        }
    }

    private Tile(Tile tile) {
        super(tile.left, tile.right);
        this.isFlipped = tile.isFlipped;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
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
