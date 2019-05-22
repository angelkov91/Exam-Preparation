import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length; i++) {
            String symbol = expression[i];
            int number = 0;
            try {
                char a = symbol.charAt(0);
                if (Character.isDigit(a)) {
                    number = Integer.parseInt(symbol);
                    queue.offer(number + "");
                } else if (Character.isLetter(a)) {
                    queue.offer(symbol);
                } else
                    number = Integer.parseInt(symbol);
            } catch (Exception c) {

                if (symbol.equals(")")) {
                    String out = "";
                    while (!"(".equals(out = stack.pop())) {
                        queue.offer(out);
                    }
                } else if (symbol.equals("("))
                    stack.push(symbol + "");
                if (stack.size() == 0 && !symbol.equals(")"))
                    stack.push(symbol + "");
                else {
                    if (symbol.equals("+")) {
                        String inStack = stack.peek();
                        while (!inStack.equals("+") && !inStack.equals("-") && stack.size() != 0 && !inStack.equals("(")) {
                            inStack = stack.pop();
                            queue.offer(inStack);
                            stack.push(inStack);
                        }
                        queue.offer(inStack);
                    } else if (symbol.equals("-")) {
                        String inStack = stack.peek();
                        while (stack.size() != 0 && !inStack.equals("(") && !stack.equals("-")) {
                            inStack = stack.pop();
                            queue.offer(inStack);
                            stack.push(inStack);
                        }
                        queue.offer(inStack);
                    } else if (symbol.equals("/")) {
                        String inStack = stack.peek();
                        while (!inStack.equals("/") && !inStack.equals("*") && !inStack.equals("-") && !inStack.equals("+")) {
                            inStack = stack.pop();
                            queue.offer(inStack);
                            inStack = stack.peek();
                        }
                        queue.offer(inStack);

                    } else if (symbol.equals("*")) {
                        String inStack = stack.peek();
                        while (!inStack.equals("/") && !inStack.equals("*") && !inStack.equals("-") && !inStack.equals("+")) {
                            inStack = stack.pop();
                            queue.offer(inStack);
                            inStack = stack.peek();
                        }
                        queue.offer(inStack);

                    }
                }
            }
        }
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }


    }
}
