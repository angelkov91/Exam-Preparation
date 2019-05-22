import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < kids.length; i++) {
            queue.offer(kids[i]);
        }
        while (queue.size()!=1){
            for (int i = 1; i <= n; i++) {
                if (i!=n){
                    String save = queue.poll();
                    queue.offer(save);
                }
                else
                    System.out.println("Removed "+queue.poll());
            }
        }
        System.out.println("Last is "+queue.poll());


    }
}
