import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> comands = new ArrayDeque<>();
        String text = "";
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            switch (type) {
                case "1":
                    text += input[1];
                    comands.push(type);
                    comands.push(input[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    comands.push(type);
                    if (count < text.length()) {
                        String bin = text.substring(text.length() - count);
                        int index = text.lastIndexOf(bin);
                        text = text.substring(0,index);
                        comands.push(bin);
                    } else {
                        comands.push(text);
                        text = "";
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    char printChar = text.charAt(index - 1);
                    System.out.println(printChar);
                    break;
                case "4":
                    String textPop = comands.pop();
                    String typePop = comands.pop();
                    if (typePop.equals("1")){
                        int indexOf = text.indexOf(textPop);
                        String sub = text.substring(indexOf);
                        text = text.replace(sub,"");
                    }
                    else if (typePop.equals("2")){
                        text += textPop;
                    }


                    break;
            }

        }
    }

}
