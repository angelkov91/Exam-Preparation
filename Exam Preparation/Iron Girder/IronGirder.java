import java.util.*;

public class IronGirder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotate = "";
        Map<String, Integer> townTime = new TreeMap<>();
        Map<String, Integer> townPassengers = new TreeMap<>();
        while (!"Slide rule".equals(rotate = scanner.nextLine())) {
            String[] input = rotate.split(":|->");
            String nameTown = input[0];
            int passangersCount = Integer.parseInt(input[2]);
            String ambush = "";
            int time = 0;
            if (input[1].equals("ambush")) {
                if (townTime.containsKey(nameTown)) {
                    int a = townPassengers.get(nameTown) - passangersCount;
                    townPassengers.put(nameTown, a);
                    townTime.put(nameTown, 0);
                }

            } else {
                time = Integer.parseInt(input[1]);
                if (!townTime.containsKey(nameTown)) {
                    townTime.put(nameTown, time);
                    townPassengers.put(nameTown, passangersCount);
                } else {
                    townPassengers.put(nameTown, townPassengers.get(nameTown) + passangersCount);
                    if (townTime.get(nameTown) == 0) {
                        townTime.put(nameTown, time);
                    } else if (townTime.get(nameTown) > time) {
                        townTime.remove(nameTown);
                        townTime.put(nameTown, time);
                    }
                }
            }

        }
        List<String> remove = new ArrayList<>();
        for (Map.Entry<String, Integer> kv : townTime.entrySet()) {
            if (kv.getValue()<=0 || townPassengers.get(kv.getKey())<=0) {
                remove.add(kv.getKey());
            }
        }
        for (String s : remove) {
            if (townTime.containsKey(s)) {
                townTime.remove(s);
                townPassengers.remove(s);
            }
        }
        townTime.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(String.format("%s -> Time: %d -> Passengers: %d", e.getKey(), e.getValue(), townPassengers.get(e.getKey()))));
    }
}
