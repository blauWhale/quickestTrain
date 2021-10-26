import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Grüezi, bitte alle einsteigen. Es geht nach: ");
        //JSON parser object to parse read file
        readJsonFile();


    }

    private static void readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("destinations.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray destinationArray = (JSONArray) obj;

            //Iterate over employee array
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
        System.out.println( name +" in: ("+ yCord + "/" + xCord+ ")");
    }


}