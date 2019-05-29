import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String,Double>> allMarkets = new TreeMap<>();
        String revision = "";
        while (!"Revision".equals(revision = scanner.nextLine())){
            String[] input = revision.split(", ");
            String shopName = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);
            if (!allMarkets.containsKey(shopName)){
                allMarkets.put(shopName, new LinkedHashMap<>());
                allMarkets.get(shopName).put(product,price);
            }
            else
                allMarkets.get(shopName).put(product,price);
        }

        allMarkets.forEach((market,products) -> {
            System.out.println(String.format("%s->",market));
            products.forEach((product,price) -> {
                System.out.println(String.format("Product: %s, Price: %.1f",product,price));
            });
        });

    }
}
