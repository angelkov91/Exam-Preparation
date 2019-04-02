import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("&");
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        List<String> codes = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {
                String output = matcher.group().toUpperCase();
                String toCode = "";
                if (output.length() % 4 == 0) {
                    for (int j = 0; j < output.length(); j++) {
                        char symbol = output.charAt(j);
                        if (Character.isLetter(symbol)) {
                            if (j % 4 == 0 && j != 0)
                                toCode += "-";
                            toCode += symbol;
                        } else if (Character.isDigit(symbol)) {
                            int a = symbol - '0';
                            a = 9 - a;
                            if (j % 4 == 0 && j != 0)
                                toCode += "-";
                            toCode += a;
                        }
                    }
                } else if (output.length() % 5 == 0) {
                    for (int j = 0; j < output.length(); j++) {
                        char symbol = output.charAt(j);
                        if (Character.isLetter(symbol)) {
                            if (j % 5 == 0 && j != 0)
                                toCode += "-";
                            toCode += symbol;
                        } else if (Character.isDigit(symbol)) {
                            int a = symbol - '0';
                            a = 9 - a;
                            if (j % 5 == 0 && j != 0)
                                toCode += "-";
                            toCode += a;
                        }
                    }
                }
                codes.add(toCode);
            }
        }
        System.out.println(codes.toString().replaceAll("\\[|\\]",""));
    }
}
