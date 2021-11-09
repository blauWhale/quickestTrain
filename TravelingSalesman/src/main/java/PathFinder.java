/**
 * Author: Raphael Blaauw, Oliver Achermann
 * Version: 1.0
 * Datum: 09.11.2021
 * Title: Traveling Salesman
 */
import java.util.ArrayList;
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
        // look for closest destination from current point
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
            // mark every visited coordinate
            if(!previousIndexes.contains(indexOfCurrentClosestDestination)){
                previousIndexes.add(indexOfCurrentClosestDestination);
            }
            // mark the closest destination as starting point for next travel
            currentIndex = indexOfCurrentClosestDestination;
            if(!shortestWay.contains(coordinatePoint.get(indexOfCurrentClosestDestination))){
                shortestWay.add(coordinatePoint.get(indexOfCurrentClosestDestination));
            }

        }
        shortestWay.add(coordinatePoint.get(startingIndex));

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



