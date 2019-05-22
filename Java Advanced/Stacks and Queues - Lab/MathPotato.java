import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;
        for (int i = 0; i < kids.length; i++) {
            queue.offer(kids[i]);
        }
        while (queue.size() != 1) {
            for (int i = 1; i <= n; i++) {
                if (i != n) {
                    String save = queue.poll();
                    queue.offer(save);
                }
            }
            if (!isPrime(count))
                System.out.println("Removed " + queue.poll());
            else
                System.out.println("Prime " + queue.peek());
            count++;

        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int a) {
        if (a == 1)
            return false;
        else {
            for (int i = 2; i < a; i++) {
                if (a % i == 0)
                    return false;
            }
            return true;
        }
    }
}
