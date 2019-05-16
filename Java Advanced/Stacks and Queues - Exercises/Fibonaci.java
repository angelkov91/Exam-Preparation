import java.util.ArrayDeque;
import java.util.Scanner;

public class fibonaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1l);
        stack.push(1l);
        for (int i = 1; i <= n; i++) {
            stack.offer(stack.poll()+stack.peek());
        }
        System.out.println(stack.peek());
    }
}
