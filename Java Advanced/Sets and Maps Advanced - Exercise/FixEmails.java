import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        while (!"stop".equals(name = scanner.nextLine())){
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com"))
                System.out.println(String.format("%s -> %s",name,email));
        }
    }
}
