package com.starr.domino;

public class Tile implements Comparable{

    private int left;
    private int right;

    public Tile(int left, int right) {
        if(left > right){
            int tmp = left;
            left = right;
            right = tmp;
        }
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

        if (left != tile.left) return false;
        return right == tile.right;
    }

    @Override
    public int hashCode() {
        int result = left;
        result = 31 * result + right;
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
