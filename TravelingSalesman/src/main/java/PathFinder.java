import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PathFinder {

    public ArrayList<int[]> findShortestPath(TreeMap<String, int[]> cityMap, int startingIndex) {
        ArrayList<int[]> coordinatePoint = new ArrayList<>();

        for (Map.Entry<String, int[]> entry : cityMap.entrySet()) {
            coordinatePoint.add(entry.getValue());
        }
        ArrayList<int[]> shortestWay = new ArrayList<>();
        ArrayList<Integer> previousIndexes = new ArrayList<>();
        int currentIndex = startingIndex;
        shortestWay.add(coordinatePoint.get(currentIndex));
        for (int i = 0; i < coordinatePoint.size(); i++) {
            double currentDiff = Integer.MAX_VALUE;
            int indexOfCurrentClosestDestination = 0;
            for (int j = 0; j < coordinatePoint.size(); j++) {
                double difference = calculateDifference(coordinatePoint.get(currentIndex), coordinatePoint.get(j));
                if (!isInPreviousIndexes(previousIndexes, j) && difference < currentDiff &&  j != currentIndex) {
                    currentDiff = difference;
                    indexOfCurrentClosestDestination = j;
                }
            }
            if(!previousIndexes.contains(indexOfCurrentClosestDestination)){
                previousIndexes.add(indexOfCurrentClosestDestination);
            }
            currentIndex = indexOfCurrentClosestDestination;
            if(!shortestWay.contains(coordinatePoint.get(indexOfCurrentClosestDestination))){
                shortestWay.add(coordinatePoint.get(indexOfCurrentClosestDestination));
            }

        }
        shortestWay.add(coordinatePoint.get(startingIndex));
        for(int[] point : shortestWay){
            for (Map.Entry<String, int[]> entry : cityMap.entrySet()) {
                if(Arrays.equals(entry.getValue(),point)){
                    System.out.println(entry.getKey() + Arrays.toString(entry.getValue()));
                }
            }
        }
        return shortestWay;
    }

    private boolean isInPreviousIndexes( ArrayList<Integer> previousIndexes, int key){
        for (int i : previousIndexes){
            if(i == key){
                return true;
            }
        }
        return false;
    }

    public double calculateDifference(int[] pointA, int[] pointB) {
        return Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2.0) + Math.pow((pointA[1] - pointB[1]), 2.0));
    }
}


