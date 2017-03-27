package com.starr.domino.util;

/**
 * Util class for storage domino dots values
 *
 * @author Tania Kysla
 */
public final class DominoConfig {

    /**
     * Minimum allowed dots
     */
    public static final int MIN = 0;

    /**
     * Maximum allowed dots
     */
    public static final int MAX = 6;

    private DominoConfig() {
    }

    /**
     * Calculate sum of dominoes tiles depend on dots values
     *
     * @return count dominoes count
     */
    public static int calculateDominoesCount() {
        int max = MAX - MIN;
        return ((max * max + (3 * max) + 2) / 2);
    }
}
