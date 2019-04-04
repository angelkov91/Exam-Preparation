import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String loop = "";
        while (!"end".equals(loop = scanner.nextLine())) {
            String decryptCode = (decrypt(key, loop));
            if (decryptCode.contains("@")) {
                int indexOfQ = decryptCode.indexOf("@");
                decryptCode = decryptCode.substring(indexOfQ + 1);
                String kidName = "";
                for (int i = 0; i < decryptCode.length(); i++) {
                    char letter = decryptCode.charAt(i);
                    if (Character.isLetter(letter))
                        kidName += letter;
                    else
                        break;
                }
                int indexOfName = decryptCode.indexOf(kidName);
                decryptCode = decryptCode.substring(indexOfName+kidName.length());
                Pattern pattern = Pattern.compile("[!<=\\!][G|n][!=\\!)]");
                Matcher matcher = pattern.matcher(decryptCode);
                int indexOfMatcher = 0;
                if (matcher.find()){
                    String match = matcher.group();
                    indexOfMatcher = decryptCode.indexOf(match);
                    decryptCode = decryptCode.substring(0,indexOfMatcher);
                    if (!decryptCode.contains("@")&&!decryptCode.contains("!")&&!decryptCode.contains("-")&&!decryptCode.contains(":")&&!decryptCode.contains(">"))
                        System.out.println(kidName);
                }
            }
        }
    }

    public static String decrypt(int key, String cryptCode) {
        String output = "";
        for (int i = 0; i < cryptCode.length(); i++) {
            char symbol = cryptCode.charAt(i);
            symbol -= key;
            output += symbol;
        }
        return output;
    }
}
