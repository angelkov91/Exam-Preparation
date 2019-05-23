import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        Map<String, String> phoneBook = new HashMap<>();
        while (!"search".equals(input = scanner.nextLine())){
            String[] data = input.split("-");
            phoneBook.putIfAbsent(data[0], data[1]);
        }
        while (!"stop".equals(input = scanner.nextLine())){
            if (phoneBook.containsKey(input))
                System.out.println(String.format("%s -> %s",input,phoneBook.get(input)));
            else
                System.out.println(String.format("Contact %s does not exist.",input));
        }
    }
}
