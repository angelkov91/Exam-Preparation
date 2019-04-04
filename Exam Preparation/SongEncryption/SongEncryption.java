import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loop = "";
        Pattern patternArtist = Pattern.compile("^[A-Z](?:[a-z' ]*)$");
        Pattern patternSong = Pattern.compile("^[A-Z]+(?:[A-Z ])*$");
        List<String> matchList = new ArrayList<>();
        while (!"end".equals(loop = scanner.nextLine())){
        String[] input = loop.split(":");
            Matcher matcherArtist = patternArtist.matcher(input[0]);
            Matcher matcherSong = patternSong.matcher(input[1]);
            if (matcherArtist.find()&&matcherSong.find()){
                int l = matcherArtist.group().length();
                matchList.add("Successful encryption: "+encryption(matcherArtist.group(),l)+"@"+encryption(matcherSong.group(),l));
            }
            else
                matchList.add("Invalid input!");
        }
        for (String s : matchList) {
            System.out.println(s);
        }
    }
    public static String encryption(String a, int b){
        String encrypt ="";
        for (int i = 0; i < a.length(); i++) {
            char symbol = a.charAt(i);
            if (Character.isLetter(symbol)){
                if (Character.isUpperCase(symbol)){
                    int num = symbol+b;
                    if (num>90) {
                        num = num-90+64;
                    }
                    char encr = (char)num;
                    encrypt+=encr;
                }
                else {
                    int num = symbol+b;
                    if (num>122) {
                        num = num-122+96;
                    }
                    char encr = (char)num;
                    encrypt+=encr;
                }
            }
            else
                encrypt+=symbol;
        }
        return encrypt;
    }
}
