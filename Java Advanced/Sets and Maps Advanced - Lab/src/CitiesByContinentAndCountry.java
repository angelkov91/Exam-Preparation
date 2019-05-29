import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String, ArrayList<String>>> listOfCCC = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!listOfCCC.containsKey(continent)){
                listOfCCC.put(continent, new LinkedHashMap<>());
                listOfCCC.get(continent).put(country, new ArrayList<>());
                listOfCCC.get(continent).get(country).add(city);
            }
            else {
                if (!listOfCCC.get(continent).containsKey(country)){
                    listOfCCC.get(continent).put(country,new ArrayList<>());
                    listOfCCC.get(continent).get(country).add(city);
                }
                else {
                    listOfCCC.get(continent).get(country).add(city);
                }
            }
        }
        listOfCCC.forEach((continent, country) -> {
            System.out.println(String.format("%s:",continent));
            country.forEach((count, city) -> {
                System.out.println(String.format("%s -> %s",count,city.toString().replaceAll("\\[|\\]","")));
            });
        });
    }
}
