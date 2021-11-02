import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

public class PathFinderTest {

    private TreeMap<String, int[]> cityMap;


    @Test
    public void test(){
        cityMap = new TreeMap<>();
        cityMap.put("Zürich", new int[]{8, 8});
        cityMap.put("Argau", new int[]{1, 1});
        cityMap.put("Luzern", new int[]{3, 3});
        PathFinder pf = new PathFinder();
        int[] result = pf.findShortestPath(cityMap, 0).get(0);
        Assert.assertEquals(1,result[0]);
    }

    @Test
    public void calculateDistanceTest(){
        PathFinder pf = new PathFinder();
        double diff = pf.calculateDifference(new int[]{0, 0},new int[]{1, 1});
        Assert.assertEquals(1.4142135623730951,diff);
    }
}
