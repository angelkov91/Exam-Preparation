import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = "";
        Map<String, Map<String, Integer>> concert = new LinkedHashMap<>();
        while (!"End".equals(rotation = scanner.nextLine())) {
            Pattern pattern = Pattern.compile
                    ("^(?<name>[A-Z]*[a-z]*+\\s[A-Z]*[a-z]*\\s*)\\@(?<place>[A-Z]*[a-z]*+\\s*" +
                            "([A-Z]*[a-z]*))\\s(?<price>\\d*)\\s(?<people>\\d*)$");
            Matcher matcher = pattern.matcher(rotation);
            if (matcher.find()) {
                String artist = matcher.group("name").trim();
                String place = matcher.group("place").trim();
                int price = Integer.parseInt(matcher.group("price"));
                int people = Integer.parseInt(matcher.group("people"));
                int money = price*people;
                if (!concert.containsKey(place)) {
                    concert.put(place, new HashMap<>());
                    concert.get(place).put(artist, money);

                }
                else {

                    if (!concert.get(place).containsKey(artist)){
                        concert.get(place).put(artist,money);
                    }
                    else {
                        concert.get(place).put(artist,concert.get(place).get(artist)+money);
                    }
                }
            }
        }
        concert.forEach((place, artist) ->{
            System.out.println(place);
            artist.entrySet().stream().sorted((e1,e2)->{
                int sort = Integer.compare(e2.getValue(),e1.getValue());
                if (sort == 0)
                    sort = e1.getKey().compareTo(e2.getKey());
                return sort;
            }).forEach(e -> {
                System.out.println(String.format("#  %s -> %d",e.getKey(),e.getValue()));
            });
        });
    }
}
