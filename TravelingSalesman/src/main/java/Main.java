

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<String, int[]> cityMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        readJsonFile();
        PathFinder pathFinder = new PathFinder();
        ArrayList<int[]> shortestWay = pathFinder.findShortestPath(cityMap);

    }

    private static void readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("destinations.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray destinationArray = (JSONArray) obj;

            destinationArray.forEach(destination -> parseDestinationObject((JSONObject) destination));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseDestinationObject(JSONObject destination) {
        //Get employee object within list
        JSONObject destinationObject = (JSONObject) destination.get("destination");

        String name = (String) destinationObject.get("name");

        String xCord = (String) destinationObject.get("x");

        String yCord = (String) destinationObject.get("y");
        cityMap.put(name, new int[]{Integer.parseInt(xCord), Integer.parseInt(yCord)});
    }


}