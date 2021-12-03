import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileOne = "set1.txt";
        String fileTwo = "set2.txt";
        String fileThree = "set3.txt";

        ArrayList<String> cities = new ArrayList<String>(2);
        try {
            File file = new File(fileOne);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String readLine = scanner.nextLine();
                String replacedData = readLine.replaceAll("[ ]+", " ");
                if (Character.isWhitespace(replacedData.charAt(0))) {
                    replacedData = replacedData.substring(1);
                }
                String[] changedData = replacedData.split(" ");
                cities.add(Arrays.toString(changedData));
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        int numberOfCities = cities.size();
        String array_1 = "";
        String array_2 = "";
        float BestDistance = 9999999;
        String route = "1, ";
        String bestRoute = "";
        float TotalCurrentDistance = 0;
//        ArrayList<String> citiesArrayList = (ArrayList<String>) cities.clone();
        ArrayList<String> citiesArrayList = (ArrayList<String>) cities.clone();

        int combination = 1;

        for (int y = 1; y <= numberOfCities; y++) {
            combination *= y;
        }
        for (int h = 0; h <= combination; h++)
        {
            citiesArrayList.remove(0);
            Collections.shuffle(citiesArrayList);
            citiesArrayList.add(0, cities.get(0));
            for (int x = 0; x < numberOfCities; x++) {
                if (x == (numberOfCities - 1)) {
                    array_1 = citiesArrayList.get(x);
                    array_2 = citiesArrayList.get(0);
                }
                else
                {
                    array_1 = citiesArrayList.get(x);
                    array_2 = citiesArrayList.get(x + 1);
                }
                array_1 = array_1.replace("[", "");
                array_1 = array_1.replace("]", "");
                array_1 = array_1.replace(" ", "");
                array_2 = array_2.replace("[", "");
                array_2 = array_2.replace("]", "");
                array_2 = array_2.replace(" ", "");
                String[] split_array_1 = array_1.split(",");
                String[] split_array_2 = array_2.split(",");
                float x_1 = Float.parseFloat(split_array_1[1]);
                float y_1 = Float.parseFloat(split_array_1[2]);
                float x_2 = Float.parseFloat(split_array_2[1]);
                float y_2 = Float.parseFloat(split_array_2[2]);
                float calculatedDistance = (float) Math.sqrt((y_2 - y_1) * (y_2 - y_1) + (x_2 - x_1) * (x_2 - x_1));
                TotalCurrentDistance += calculatedDistance;
                System.out.println(split_array_1[0] + " trip between " + x_1 + " " + y_1 + " and " + x_2 + " " + y_2);
                //
                route = route + array_2.charAt(0) + ",";
            }
            if (TotalCurrentDistance <= BestDistance) {
                BestDistance = TotalCurrentDistance;
                bestRoute = route;
            }
            TotalCurrentDistance = 0;
            route = "1,";
        }
        System.out.println("The best path  was " + bestRoute + " with the cost of " + BestDistance + " and time required was " + System.nanoTime());
    }

}
