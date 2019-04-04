import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> bandsTime = new TreeMap<>();
        Map<String, List<String>> bandsMembers = new LinkedHashMap<>();
        String loop = "";
        int totalTime = 0;
        while (!"start of concert".equals(loop = scanner.nextLine())) {
            String[] input = loop.split("; |, ");
            String type = input[0];
            String name = input[1];

            if (type.equals("Play")) {
                int time = Integer.parseInt(input[2]);
                totalTime+=time;
                if (!bandsTime.containsKey(name))
                    bandsTime.put(name, time);
                else
                    bandsTime.put(name, bandsTime.get(name) + time);
                if (!bandsMembers.containsKey(name))
                    bandsMembers.put(name, new ArrayList<>());
            } else if (type.equals("Add")) {
                if (!bandsTime.containsKey(name))
                    bandsTime.put(name,0);
                if (!bandsMembers.containsKey(name)){
                    bandsMembers.put(name,new ArrayList<>());
                    for (int i = 2; i < input.length; i++) {
                        String member = input[i];
                        if (!bandsMembers.get(name).contains(member))
                            bandsMembers.get(name).add(member);
                    }
                }
                else if (bandsMembers.containsKey(name)){
                    for (int i = 2; i < input.length; i++) {
                        String member = input[i];
                        if (!bandsMembers.get(name).contains(member))
                            bandsMembers.get(name).add(member);
                    }
                }
            }
        }
        String band = scanner.nextLine();
        System.out.println("Total time: " + totalTime);
        bandsTime.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(String.format("%s -> %d",e.getKey(),e.getValue())));
        for (Map.Entry<String, List<String>> kv : bandsMembers.entrySet()) {
            if (kv.getKey().equals(band)){
                System.out.println(String.format("%s",kv.getKey()));
                kv.getValue().forEach(c -> {
                    System.out.println(String.format("=> %s",c));
                });
            }
        }
    }
}
