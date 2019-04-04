import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loop = "";
        Map<String, Integer> kidsToys = new TreeMap<>();
        Map<String, Integer> toys = new LinkedHashMap<>();
        while (!"END".equals(loop = scanner.nextLine())) {
            String[] input = loop.split("->");
            String kidName = input[0];
            String typeToy = input[1];
            int numberOfToys = 0;
            if (input.length == 3)
                numberOfToys = Integer.parseInt(input[2]);
            if (!kidName.equals("Remove")) {
                if (!kidsToys.containsKey(kidName))
                    kidsToys.put(kidName, numberOfToys);
                else
                    kidsToys.put(kidName, kidsToys.get(kidName) + numberOfToys);
                if (!toys.containsKey(typeToy))
                    toys.put(typeToy, numberOfToys);
                else
                    toys.put(typeToy, toys.get(typeToy) + numberOfToys);
            } else
                kidsToys.remove(typeToy);
        }
        System.out.println("Children:");
        kidsToys.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(String.format("%s -> %d",e.getKey(),e.getValue())));
        System.out.println("Presents:");
        for (Map.Entry<String, Integer> kv : toys.entrySet()) {
            System.out.println(String.format("%s -> %d",kv.getKey(),kv.getValue()));
        }
    }
}
