import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> urlsStack = new ArrayDeque<>();
        String input = "";
        while (!"Home".equals(input = scanner.nextLine())){
            if (!input.equals("back")) {
                urlsStack.push(input);
                System.out.println(urlsStack.peek());
            }
            else {
                if (urlsStack.size()>1){
                    urlsStack.pop();
                    System.out.println(urlsStack.peek());
                }
                else {
                    System.out.println("no previous URLs");
                }
            }
        }
    }
}
