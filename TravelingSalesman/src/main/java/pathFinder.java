package main.java;

import java.util.ArrayList;

public class pathFinder {

    static int[] one = {0, 0};
    static int[] two = {1, 1};
    static int[] three = {3,3};
    static int[] four = {8,8};
    static ArrayList<int[]> coordinatePoint = new ArrayList<>();
    static ArrayList<int[]> shortestWay = new ArrayList<>();


    public static void main(String[] args) {
        coordinatePoint.add(one);
        coordinatePoint.add(three);
        coordinatePoint.add(four);
        coordinatePoint.add(two);
        shortestWay.add(coordinatePoint.get(0));
        findShortestPath();
    }

    private static void findShortestPath() {
        int previousIndex = 0;
        int currentIndex = 0;
        for (int i = 0; i < coordinatePoint.size(); i++) {
            double currentDiff = 0;
            int indexOfCurrentClosestDestination = 0;
            for (int j = 0; j < coordinatePoint.size(); j++) {
                double difference = calculateDifference(coordinatePoint.get(currentIndex), coordinatePoint.get(j));
                if (currentDiff == 0 || (difference < currentDiff && j != previousIndex)) {
                    currentDiff = difference;
                    indexOfCurrentClosestDestination = j;
                }
            }
            previousIndex = currentIndex;
            currentIndex = indexOfCurrentClosestDestination;
            shortestWay.add(coordinatePoint.get(indexOfCurrentClosestDestination));
        }

    }


    private static double calculateDifference(int[] pointA, int[] pointB) {
        return Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2.0) + Math.pow((pointA[1] - pointB[1]), 2.0));
    }
}
