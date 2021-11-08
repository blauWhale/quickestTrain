import java.util.*;

public class Ui {

    private final Scanner scanner;

    public Ui(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printResults(ArrayList<int[]> shortestWay, TreeMap<String, int[]> cityMap) {
        for (int[] point : shortestWay) {
            for (Map.Entry<String, int[]> entry : cityMap.entrySet()) {
                if (Arrays.equals(entry.getValue(), point)) {
                    System.out.println(entry.getKey() + Arrays.toString(entry.getValue()));
                }
            }
        }
    }

    public int askForStartingPoint(TreeMap<String, int[]> cityMap) {
        ArrayList<String> cityNames = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : cityMap.entrySet()) {
            cityNames.add(entry.getKey());
        }
        for (int station = 0; station < cityNames.size(); station++) {
            System.out.println("[" + (station) + "] " + cityNames.get(station));
        }
        String cityname = null;
        int input = 0;
        boolean valid = false;
        do {
            try {
                System.out.println("Choose your startpoint:");
                input = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < cityNames.size(); i++) {
                    cityname = cityNames.get(input);
                }
                if (input >= 0 && input < cityNames.size())
                    System.out.println("You chose " + cityname);
                valid = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Choose one of the teams listed (0-4)");
            } catch (NumberFormatException e) {

                System.out.println("Please type a number");
            }
        } while (!valid);
        return input;
    }
}
