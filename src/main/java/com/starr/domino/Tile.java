package com.starr.domino;

public class Tile implements Comparable{

    private int left;
    private int right;

    public Tile(int left, int right) {
        this.right = right;
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
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
        int result = right;
        result = 31 * result + 31 * left;
        return result;
    }

    @Override
    public String toString() {
        return "["+left+"|"+right+"]";
    }

    public int compareTo(Object o) {

        return 0;
    }
}
