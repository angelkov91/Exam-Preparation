import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double,Integer> numbers = new LinkedHashMap<>();
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        for (double in : input) {
            if (!numbers.containsKey(in))
                numbers.put(in,1);
            else
                numbers.put(in,numbers.get(in)+1);
        }
        numbers.forEach((key,value) -> System.out.println(String.format("%.1f -> %d",key,value)));
    }
}
