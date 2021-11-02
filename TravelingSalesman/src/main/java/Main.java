

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<String, int[]> cityMap = new TreeMap<>();

    public static void main(String[] args) {
        readJsonFile();
        PathFinder pathFinder = new PathFinder();
        Scanner scanner = new Scanner(System.in);
        readJsonFile();
        System.out.println("Grüezi, bitte alle einsteigen. Es geht nach: \n");
        ArrayList<String> cityNames = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : cityMap.entrySet()) {
            cityNames.add(entry.getKey());
        }

        System.out.println("Choose your startpoint:");
        for (int station = 0; station < cityNames.size(); station++) {
            System.out.println("[" + (station) + "] " + cityNames.get(station));
        }

        String cityname = null;
        String input = null;
        try {
            input = scanner.nextLine();
            for (int i = 0; i < cityNames.size(); i++) {
                cityname = cityNames.get(Integer.parseInt(input));
            }

            System.out.println("You chose " + cityname);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Choose one of the teams listed (0-4)");
        } catch (NumberFormatException e) {
            throw new RuntimeException("Please type a number");
        }
        pathFinder.findShortestPath(cityMap, Integer.parseInt(input));
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