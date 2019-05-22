import java.util.*;
import java.util.stream.Collectors;

public class PosionPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        List<Integer> listPlants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> die = new ArrayList<>();
        boolean dying = true;
        int counter = -1;
        while (dying) {
            counter++;
            int isDying = 0;
            for (int i = 0; i < listPlants.size()-1 ; i++) {
                if (listPlants.get(i)<listPlants.get(i+1)){
                    die.add(listPlants.get(i+1));
                    isDying++;
                }
            }
            for (int i = 0; i < die.size(); i++){
                listPlants.remove(die.get(i));
            }
            die.clear();
            if (isDying==0)
                dying = false;
        }
        System.out.println(counter);
    }
}
