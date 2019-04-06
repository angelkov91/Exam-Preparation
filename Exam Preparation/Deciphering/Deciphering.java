import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[d-z\\#\\{\\}\\|]*$");
        Matcher matcher = pattern.matcher(code);
        String correctCode ="";
        if (matcher.find())
            correctCode=matcher.group();
        else
            System.out.println("This is not the book you are looking for.");
        if (!"".equals(correctCode)) {
            correctCode = deCode(code);
            String[] substrings = scanner.nextLine().split(" ");
            correctCode = correctCode.replaceAll(substrings[0],substrings[1]);
            System.out.println(correctCode);
        }

    }
    public static String deCode(String a){
        String input = "";
        for (int i = 0; i < a.length(); i++) {
            int symbolNum = a.charAt(i);
            char symbol = (char)(symbolNum-3);
            input+=symbol;
        }
        return input;
    }
}
