import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.TreeMap;

public class PathFinderTest {

    private static TreeMap<String, int[]> cityMap;
    private static PathFinder pf;


    @Before
    public void init(){
        cityMap = new TreeMap<>();
        cityMap.put("Zürich", new int[]{8, 8});
        cityMap.put("Argau", new int[]{1, 1});
        cityMap.put("Luzern", new int[]{3, 3});
        pf = new PathFinder();
    }

    @Test
    public void testShortestPathStartingPoint(){
        int[] result = pf.findShortestPath(cityMap, 0).get(0);
        Assert.assertEquals(1,result[0]);
    }
    @Test
    public void testShortestPathSecondPoint(){
        int[] result = pf.findShortestPath(cityMap, 0).get(1);
        Assert.assertEquals(3,result[0]);
    }

    @Test
    public void testShortestPathThirdPoint(){
        int[] result = pf.findShortestPath(cityMap, 0).get(2);
        Assert.assertEquals(8,result[0]);
    }

    @Test
    public void testShortestPathEndPoint(){
        int[] result = pf.findShortestPath(cityMap, 0).get(3);
        Assert.assertEquals(1,result[0]);
    }

    @Test
    public void calculateDistanceTest(){
        PathFinder pf = new PathFinder();
        double diff = pf.calculateDifference(new int[]{0, 0},new int[]{1, 1});
        Assert.assertEquals(1.4142135623730951,diff);
    }
}
