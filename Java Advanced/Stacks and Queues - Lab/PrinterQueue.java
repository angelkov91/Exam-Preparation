import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!"print".equals(input= scanner.nextLine())){
            if (input.equals("cancel")){
                if (queue.isEmpty())
                    System.out.println("Printer is on standby");
                else
                    System.out.println("Canceled "+queue.poll());
            }
            else
                queue.offer(input);
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
