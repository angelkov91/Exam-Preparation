import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String,Integer>> usersLongs = new TreeMap<>();
        String rotate = "";
        while (!"end".equals(rotate = scanner.nextLine())){
            String[] input = rotate.split(" ");
            String ip = input[0].substring(3);
            String user = input[2].substring(5);
            if (!usersLongs.containsKey(user)){
                usersLongs.put(user, new LinkedHashMap<>());
                usersLongs.get(user).put(ip,1);
            }
            else {
                if (!usersLongs.get(user).containsKey(ip))
                    usersLongs.get(user).put(ip,1);
                else
                    usersLongs.get(user).put(ip,usersLongs.get(user).get(ip)+1);
            }
        }
        usersLongs.forEach((user, data) -> {
            System.out.println(user+":");
            int size = data.size();
            int counter = 1;
            for (Map.Entry<String, Integer> kv : data.entrySet()) {
                if (size!=counter) {
                    System.out.print(String.format("%s => %d, ", kv.getKey(), kv.getValue()));
                    counter++;
                }
                else
                    System.out.print(String.format("%s => %d. ", kv.getKey(), kv.getValue()));
            }
            System.out.println();
        });
    }
}
