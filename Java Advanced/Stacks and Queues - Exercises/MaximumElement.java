import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfComands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        for (int i = 0; i < numberOfComands; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input.length==1){
                int type = input[0];
                if (type==2)
                    stackNumbers.pop();
                else
                    System.out.println(maxElement(stackNumbers));
            }
            else {
                stackNumbers.push(input[1]);
            }
        }
    }
    private static int maxElement(ArrayDeque<Integer> a){
        int maxElement = Integer.MIN_VALUE;
        for (Integer stackNum : a) {
            if (maxElement < stackNum)
                maxElement=stackNum;
        }
         return maxElement;
    }
}
