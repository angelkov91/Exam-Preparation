import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loop = "";
        int time = 0;
        Map<String,Integer> works = new LinkedHashMap<>();
        works.put("dishes",0);
        works.put("clean",0);
        works.put("laundry",0);
        while (!"wife is happy".equals(loop = scanner.nextLine())) {
            Pattern dishes = Pattern.compile("(?<=<)[a-z0-9]+(?=>)");
            Pattern cleaning = Pattern.compile("(?<=\\[)[A-Z0-9]+(?=\\])");
            Pattern laundry = Pattern.compile("(?<=\\{).+(?=\\})");
            Matcher matchDish = dishes.matcher(loop);
            Matcher matchClen = cleaning.matcher(loop);
            Matcher matchLaun = laundry.matcher(loop);
            String match = "";
            String type = "";
            int timePerWork = 0;
            if (matchClen.find()) {
                match += matchClen.group();
                type="clean";
            }
            else if (matchDish.find()) {
                match += matchDish.group();
                type="dishes";
            }
            else if (matchLaun.find()) {
                match += matchLaun.group();
                type="laundry";
            }
            for (int i = 0; i < match.length(); i++) {
                char symbol = match.charAt(i);
                if (Character.isDigit(symbol)) {
                    timePerWork += symbol - '0';
                }
            }
            time+=timePerWork;
            if (works.containsKey(type))
                works.put(type,works.get(type)+timePerWork);
        }
        System.out.println("Doing the dishes - "+works.get("dishes")+" min.");
        System.out.println("Cleaning the house - "+works.get("clean")+" min.");
        System.out.println("Doing the laundry - "+works.get("laundry")+" min.");
        System.out.println("Total - "+time+" min.");
    }
}
