import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> carNumbers = new HashSet<>();
        String inputs = "";
        while (!"END".equals(inputs = scanner.nextLine())){
            String[] decript = inputs.split(", ");
            String type = decript[0];
            String number = decript[1];
            switch (type) {
                case "IN":
                    carNumbers.add(number);
                    break;
                case "OUT":
                    carNumbers.remove(number);
                    break;
            }
        }
        if (!carNumbers.isEmpty())
        carNumbers.forEach(System.out::println);
        else
            System.out.println("Parking Lot is Empty");
    }
}
