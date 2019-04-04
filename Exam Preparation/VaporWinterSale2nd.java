import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VaporWinterSale2nd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> gameDlc = new TreeMap<>();
        Map<String, Double> gamePrice = new TreeMap<>();
        Map<String, Double> gameFinalResult = new TreeMap<>();
        String[] input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            if (input[i].contains("-")){
                String[] shredding = input[i].split("-");
                String name = shredding[0];
                double price = Double.parseDouble(shredding[1]);
                gamePrice.putIfAbsent(name,price);
            }
            else if (input[i].contains(":")){
                String[] shredding = input[i].split(":");
                String name = shredding[0];
                String dlc = shredding[1];
                if (gamePrice.containsKey(name)){
                    gameDlc.put(name,dlc);
                    gamePrice.put(name,gamePrice.get(name)*1.2);


                }
            }

        }
        for (Map.Entry<String, Double> kv : gamePrice.entrySet()) {
            if (gameDlc.containsKey(kv.getKey())){
                String saver = kv.getKey()+" - "+gameDlc.get(kv.getKey());
                gameFinalResult.put(saver,kv.getValue()*0.5);
            }
        }
        for (Map.Entry<String, String> kv : gameDlc.entrySet()) {
            if (gamePrice.containsKey(kv.getKey()))
                gamePrice.remove(kv.getKey());
        }
        gameFinalResult.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue())
                .forEach(e -> System.out.println(String.format("%s - %.2f",e.getKey(),e.getValue())));
        gamePrice.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                .forEach(e-> System.out.println(String.format("%s - %.2f",e.getKey(),e.getValue()*0.8)));

    }
}
