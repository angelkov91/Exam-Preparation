import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char type = text.charAt(i);
            if (!symbols.containsKey(type))
                symbols.put(type, 1);
            else
            symbols.put(type, symbols.get(type) + 1);
        }
        symbols.forEach((key, value) -> System.out.println(String.format("%s: %d time/s", key, value)));
    }
}
