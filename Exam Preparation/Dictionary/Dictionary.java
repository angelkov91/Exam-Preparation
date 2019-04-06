import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new TreeMap<>();
        String[] inputLines = scanner.nextLine().split(" \\| ");
        String[] inputWords = scanner.nextLine().split(" \\| ");
        String comand = scanner.nextLine();
        for (int i = 0; i < inputLines.length; i++) {
            String[] forKey = inputLines[i].split(": ");
            String key = forKey[0];
            String value = forKey[1];
            if (!dictionary.containsKey(key)){
                dictionary.put(key, new ArrayList<>());
                    dictionary.get(key).add(value);

            }
            else {
                if (!dictionary.get(key).contains(value))
                    dictionary.get(key).add(value);
            }
        }
        for (String inputWord : inputWords) {

            for (Map.Entry<String, List<String>> kv : dictionary.entrySet()) {
                if (kv.getKey().equals(inputWord)) {
                    System.out.println(kv.getKey());
                    kv.getValue().stream().sorted((a,b) -> {
                        int sort = Integer.compare(b.length(),a.length());
                        return sort;
                    }).forEach(e -> System.out.println(" -"+e));

                }
            }

        }
        if (comand.equals("List")){
            for (Map.Entry<String, List<String>> kv : dictionary.entrySet()) {
                System.out.print(kv.getKey()+" ");
            }
        }
    }
}
