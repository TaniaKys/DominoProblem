import com.starr.domino.model.AbstractTile;
import com.starr.domino.model.Tile;
import com.starr.domino.resolver.BruteForceResolver;
import com.starr.domino.resolver.IResolver;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test class for checking BruteForceResolver work.
 * @author Tania Kysla
 */
public class BruteForceResolverTest {

    private static final Logger logger = LoggerFactory.getLogger(BruteForceResolverTest.class.getSimpleName());

    private static final IResolver resolver = new BruteForceResolver();

    /**
     * Test brute force method.
     * <br>Number of tiles = 5
     * <br>Tile set = [[2|4], [5|6], [2|5], [1|6], [6|6]]
     * <br>Result size = 5
     */
    @Test
    public void case1(){
        List<AbstractTile> testList = new ArrayList<AbstractTile>();
        testList.add(new Tile(2, 4));
        testList.add(new Tile(5, 6));
        testList.add(new Tile(2, 5));
        testList.add(new Tile(1, 6));
        testList.add(new Tile(6, 6));
        int expectedResult = 5;
        List<AbstractTile> result = resolver.resolve(testList);
        logger.info("Expected result is "+expectedResult+". Longest chain size = " + result.size());
        assertEquals(expectedResult+" element chain:", expectedResult, result.size());
    }

    /**
     * Test brute force method.
     * <br>Number of tiles = 6
     * <br>Tile set = [[5|3], [1|1], [5|0], [2|2], [6|5], [2|1]]
     * <br>Result size = 3
     */
    @Test
    public void case2(){
        List<AbstractTile> testList = new ArrayList<AbstractTile>();
        testList.add(new Tile(5, 3));
        testList.add(new Tile(1, 1));
        testList.add(new Tile(5, 0));
        testList.add(new Tile(2, 2));
        testList.add(new Tile(6, 5));
        testList.add(new Tile(2, 1));
        int expectedResult = 3;
        List<AbstractTile> result = resolver.resolve(testList);
        logger.info("Expected result is "+expectedResult+". Longest chain size = " + result.size());
        assertEquals(expectedResult+" element chain:", expectedResult, result.size());
    }

    /**
     * Test brute force method.
     * <br>Number of tiles = 3
     * <br>Tile set = [[3|5], [1|1], [2|4]
     * <br>Result size = 1
     */
    @Test
    public void case3(){
        List<AbstractTile> testList = new ArrayList<AbstractTile>();
        testList.add(new Tile(3, 5));
        testList.add(new Tile(1, 1));
        testList.add(new Tile(2, 4));
        int expectedResult = 1;
        List<AbstractTile> result = resolver.resolve(testList);
        logger.info("Expected result is "+expectedResult+". Longest chain size = " + result.size());
        assertEquals(expectedResult+" element chain:", expectedResult, result.size());
    }
}
