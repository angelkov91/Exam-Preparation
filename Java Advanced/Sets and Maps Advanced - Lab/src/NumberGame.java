import java.util.*;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = generateCards(scanner.nextLine());
        LinkedHashSet<Integer> secondPlayer = generateCards(scanner.nextLine());

        System.out.println();
        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty())
                break;
            int first = firstPlayer.iterator().next();
            firstPlayer.remove(first);
            int second = secondPlayer.iterator().next();
            secondPlayer.remove(second);
            if (first>second) {
                firstPlayer.add(first);
                firstPlayer.add(second);
            }
            else if (second>first){
                secondPlayer.add(first);
                secondPlayer.add(second);
            }
            else {
                firstPlayer.add(first);
                secondPlayer.add(second);
            }

        }
        if (firstPlayer.size()>secondPlayer.size())
            System.out.println("First player win!");
        else if (secondPlayer.size()>firstPlayer.size())
            System.out.println("Second player win!");
        else
            System.out.println("Draw");



    }
    private static LinkedHashSet<Integer> generateCards(String input){
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).forEach(result::add);
        return result;
    }
}
