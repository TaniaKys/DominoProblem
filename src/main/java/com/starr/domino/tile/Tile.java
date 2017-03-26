package com.starr.domino.tile;

public class Tile implements Comparable<Tile> {

    private int left;
    private int right;
    private boolean isFlipped;
    private boolean isBusy;

    public Tile(int left, int right) {
        if(left > right){
            int tmp = left;
            left = right;
            right = tmp;
        }
        this.right = right;
        this.left = left;
    }

    public Tile(Tile tile) {
        this.left = tile.left;
        this.right = tile.right;
        this.isFlipped = tile.isFlipped;
        this.isBusy = tile.isBusy;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
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

    public Tile flip(){
        int tmp = left;
        left = right;
        right = tmp;
        isFlipped = !isFlipped;
        return this;
    }

    public void resetState(){
        if(left > right){
            int tmp = left;
            left = right;
            right = tmp;
        }
        isFlipped = false;
        isBusy = false;
    }

    public int compareTo(Tile o) {
        if(left > o.left){
            return 1;
        }
        if(left < o.left){
            return -1;
        }
        if(right > o.right){
            return 1;
        }
        if(right < o.right){
            return -1;
        }
        return 0;
    }

    public int isSuits(Tile other) {
        if (right == other.getLeft()) {
            return 1;
        }
        if (right == other.getRight()) {
            return 2;
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
        return "["+left+"|"+right+"]";
    }

}
