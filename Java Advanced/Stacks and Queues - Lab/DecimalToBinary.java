import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (number!=0) {
            while (number != 0) {
                if (number % 2 == 0) {
                    stack.push(0);
                    number /= 2;
                }
                else {
                    number -= 1;
                    stack.push(1);
                    number /= 2;
                }

            }
            for (Integer integer : stack) {
                System.out.print(integer);
            }
        }
        else
            System.out.println("0");
    }
}
