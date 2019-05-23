import java.lang.reflect.Array;
import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = sizes[0];
        int secondSetSize = sizes[1];
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));

    }
}
