package com.starr.domino.reader;

/**
 * Interface for reading domino counts
 *
 * @author Tania Kysla
 */
public interface ICountReader {

    /**
     * Read count from source
     *
     * @param countLimit Maximum allowed count
     * @return
     */
    int readCount(int countLimit);

}
