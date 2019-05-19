import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] operations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberOfElements = operations[0];
        int elementsPop = operations[1];
        int checkElement = operations[2];
        ArrayDeque<Integer> queueNums = new ArrayDeque<>();

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numberOfElements; i++) {
            queueNums.offer(input[i]);
        }
        for (int i = 0; i < elementsPop; i++) {
            queueNums.poll();
        }
        if (queueNums.contains(checkElement))
            System.out.println("true");
        else {
            if (queueNums.isEmpty())
                System.out.println("0");
            else {
                int min = Integer.MAX_VALUE;
                for (Integer integer : queueNums) {
                    if (integer < min)
                        min = integer;
                }
                System.out.println(min);
            }
        }


    }
}
