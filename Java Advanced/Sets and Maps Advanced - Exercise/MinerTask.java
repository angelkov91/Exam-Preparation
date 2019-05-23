import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Map<String, Integer> data = new LinkedHashMap<>();
        while (!"stop".equals(input = scanner.nextLine())) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!data.containsKey(input))
                data.put(input, quantity);
            else
                data.put(input, data.get(input) + quantity);
        }
        data.forEach((key, value) -> System.out.println(String.format("%s -> %d", key, value)));
    }
}
