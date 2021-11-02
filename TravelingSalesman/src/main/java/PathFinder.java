package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PathFinder {

    private double calculateDifference(int[] pointA, int[] pointB) {
        return Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2.0) + Math.pow((pointA[1] - pointB[1]), 2.0));
    }

    public void compareAllPath(TreeMap<String, int[]> cityMap) {
        int[][] coordinatePoint = new int[cityMap.size()][2];

        TreeMap<Double, ArrayList<int[]>> allCombination = new TreeMap<>();

        for(int i = 0; i < cityMap.size(); i++){
            coordinatePoint[i] = (int[]) cityMap.values().toArray()[i]; ;
        }
        printCombination(coordinatePoint,coordinatePoint.length,coordinatePoint.length);
    }

    public void combinationUtil(int[][] arr, int[][] data, int start, int end, int index, int combiLength) {

        if (index == combiLength) {
            for (int j = 0; j < combiLength; j++)
                System.out.print(Arrays.toString(data[j]) + " ");
            System.out.println("");
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= combiLength - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, combiLength);
        }
    }

    public void printCombination(int[][] arr, int arrLength, int combiLength) {
        int[][] data = new int[combiLength][2];
        combinationUtil(arr, data, 0, arrLength - 1, 0, combiLength);
    }

}


