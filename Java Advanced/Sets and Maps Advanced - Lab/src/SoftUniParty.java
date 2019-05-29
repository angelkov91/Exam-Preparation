import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();
        while (!"PARTY".equals(input = scanner.nextLine())) {
            char type = input.charAt(0);
            if (Character.isDigit(type))
                vipGuests.add(input);
            else
                regularGuests.add(input);
        }
        input = "";
        while (!"END".equals(input = scanner.nextLine())) {
            vipGuests.remove(input);
            regularGuests.remove(input);
        }
        System.out.println(vipGuests.size()+regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
