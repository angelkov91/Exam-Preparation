import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int usernamesNum = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < usernamesNum; i++) {
            String inputData = scanner.nextLine();
            if (!usernames.contains(inputData))
                usernames.add(inputData);
        }
        System.out.println(String.join(System.lineSeparator(), usernames));

    }
}
