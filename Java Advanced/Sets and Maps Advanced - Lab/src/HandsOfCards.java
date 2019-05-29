import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> playersWithValue = new LinkedHashMap<>();
        Map<String, List<String>> playerWithCards = new HashMap<>();
        String rotate = "";
        while (!"JOKER".equals(rotate = scanner.nextLine())) {
            String[] input = rotate.split(": ");
            String name = input[0];
            String[] cards = input[1].split(", ");
            if (!playerWithCards.containsKey(name)) {
                playerWithCards.put(name, new ArrayList<>());
                playersWithValue.put(name, 0);
            }
            int sum = 0;
            for (int i = 0; i < cards.length; i++) {
                if (!playerWithCards.get(name).contains(cards[i])) {
                    playerWithCards.get(name).add(cards[i]);
                    String typeCard = cards[i].substring(cards[i].length() - 1);
                    String card = cards[i].substring(0, cards[i].length() - 1);
                    int cardMultiplication = 0;
                    switch (typeCard) {
                        case "S":
                            cardMultiplication = 4;
                            break;
                        case "H":
                            cardMultiplication = 3;
                            break;
                        case "D":
                            cardMultiplication = 2;
                            break;
                        case "C":
                            cardMultiplication = 1;
                            break;
                    }
                    int cardValue = 0;
                    switch (card) {
                        case "J":
                            cardValue = 11;
                            sum += cardValue * cardMultiplication;
                            break;
                        case "Q":
                            cardValue = 12;
                            sum += cardValue * cardMultiplication;
                            break;
                        case "K":
                            cardValue = 13;
                            sum += cardValue * cardMultiplication;
                            break;
                        case "A":
                            cardValue = 14;
                            sum += cardValue * cardMultiplication;
                            break;
                        default:
                            cardValue = Integer.parseInt(card);
                            sum += cardValue * cardMultiplication;
                            break;
                    }
                }
            }
            playersWithValue.put(name,playersWithValue.get(name)+sum);
        }
        playersWithValue.forEach((player, value) -> System.out.println(String.format("%s: %d",player,value)));
    }
}


