import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> digits = new ArrayDeque<>();
        Collections.addAll(digits,input);
        while (digits.size()!=1){
            int first = Integer.parseInt(digits.poll());
            String type = digits.poll();
            int second = Integer.parseInt(digits.poll());
            switch (type){
                case "+": digits.push(""+(first+second));
                break;
                case "-": digits.push(""+(first-second));
            }
        }
        System.out.println(digits.peek());
    }
}
