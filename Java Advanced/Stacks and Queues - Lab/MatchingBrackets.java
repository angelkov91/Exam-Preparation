import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expresion = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expresion.length(); i++) {
            char symbol = expresion.charAt(i);
            if (symbol=='('){
                stack.push(i);
            }
            else if (symbol==')'){
                int start = stack.pop();
                System.out.println(expresion.substring(start,i+1));
            }
        }
    }
}
