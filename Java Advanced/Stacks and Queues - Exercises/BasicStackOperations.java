import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int elementsSize = Integer.parseInt(data[0]);
        int removedElements = Integer.parseInt(data[1]);
        String number = data[2];

        ArrayDeque<String> stackNubs = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).limit(elementsSize).forEach(stackNubs::push);
        for (int i = 0; i < removedElements; i++) {
            stackNubs.pop();
        }
        if (stackNubs.isEmpty())
            System.out.println("0");
        else {
            if (stackNubs.contains(number))
                System.out.println("true");
            else
                System.out.println(Collections.min(stackNubs));
        }
    }
}
