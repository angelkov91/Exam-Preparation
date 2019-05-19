import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        if (brackets.length()%2==0) {
            for (int i = 0; i < brackets.length(); i++) {
                char symbol = brackets.charAt(i);
                if (i == 0) {
                    if (symbol == '(' || symbol == '{' || symbol == '[') {
                        stack.push(symbol);
                        continue;
                    } else {
                        isBalanced = false;
                        break;
                    }

                }
                if (symbol == '(' || symbol == '{' || symbol == '[')
                    stack.push(symbol);
                else {
                    if (symbol == ')') {
                        if (stack.pop() != '(') {
                            isBalanced = false;
                            break;
                        }
                    } else if (symbol == ']') {
                        if (stack.pop() != '[') {
                            isBalanced = false;
                            break;
                        }
                    } else if (symbol == '}') {
                        if (stack.pop() != '{') {
                            isBalanced = false;
                            break;
                        }
                    }
                }
            }
        }
        else
            isBalanced = false;
        if (isBalanced)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
