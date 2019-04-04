import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> fullGames = new TreeMap<>();
        Map<String, Double> gamePrice = new HashMap<>();
        String[] input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("-")) {
                String[] namePrice = input[i].split("-");
                String name = namePrice[0];
                Double price = Double.parseDouble(namePrice[1]);
                gamePrice.put(name, price);
            } else if (input[i].contains(":")) {
                String[] nameDlc = input[i].split(":");
                String name = nameDlc[0];
                String dlc = nameDlc[1];
                if (gamePrice.containsKey(name)){
                    fullGames.put(name, new TreeMap<>());
                    fullGames.get(name).put(dlc,gamePrice.get(name)*1.2);
                    gamePrice.remove(name);
                }
            }
        }
        for (Map.Entry<String, Map<String, Double>> kv : fullGames.entrySet()) {
            System.out.print(String.format("%s -",kv.getKey()));
            for (Map.Entry<String, Double> kvv : kv.getValue().entrySet()) {
                System.out.println(String.format(" %s - %.2f",kvv.getKey(),kvv.getValue()*0.5));
            }
        }
        gamePrice.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed()).
                forEach(e -> System.out.println(String.format("%s - %.2f",e.getKey(),e.getValue()*0.8)));
    }
}
