

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, int[]> cityMap = new TreeMap<>();
        readJsonFile(cityMap);
        PathFinder pathFinder = new PathFinder();
        Scanner scanner = new Scanner(System.in);
        Ui userInterfaceDisplayer = new Ui(scanner);
        int startingPoint = userInterfaceDisplayer.askForStartingPoint(cityMap);
        ArrayList<int[]> shortestWay = pathFinder.findShortestPath(cityMap, startingPoint);
        userInterfaceDisplayer.printResults(shortestWay, cityMap);
        scanner.close();
    }

    private static void readJsonFile(TreeMap<String, int[]> cityMap) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("destinations.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray destinationArray = (JSONArray) obj;
            destinationArray.forEach(destination -> parseDestinationObject((JSONObject) destination, cityMap));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseDestinationObject(JSONObject destination, TreeMap<String, int[]> cityMap) {
        JSONObject destinationObject = (JSONObject) destination.get("destination");
        String name = (String) destinationObject.get("name");
        String xCord = (String) destinationObject.get("x");
        String yCord = (String) destinationObject.get("y");
        cityMap.put(name, new int[]{Integer.parseInt(xCord), Integer.parseInt(yCord)});
    }
}