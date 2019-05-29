import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> userCount = new TreeMap<>();
        Map<String, Set<String>> userLogs = new TreeMap<>();

        int numberOfInput = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfInput; i++) {
            String[] data = scanner.nextLine().split(" ");
            String ipAdress = data[0];
            String user = data[1];
            int logs = Integer.parseInt(data[2]);

            if (!userCount.containsKey(user)){
                userCount.put(user,logs);
                userLogs.put(user,new TreeSet<>());
                userLogs.get(user).add(ipAdress);
            }
            else {
                userCount.put(user,userCount.get(user)+logs);
                if (!userLogs.get(user).contains(ipAdress))
                    userLogs.get(user).add(ipAdress);
            }
        }
        userCount.forEach((user,cout) ->{
            System.out.println(String.format("%s: %d %s",user,cout, userLogs.get(user).toString()));

        });
    }
}
