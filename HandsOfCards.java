import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> powerMap = Map.ofEntries(
                Map.entry("2", 2), Map.entry("3", 3), Map.entry("4", 4),
                Map.entry("5", 5), Map.entry("6", 6), Map.entry("7", 7),
                Map.entry("8", 8), Map.entry("9", 9), Map.entry("10", 10),
                Map.entry("J", 11), Map.entry("Q", 12), Map.entry("K", 13),
                Map.entry("A", 14)
        );
        Map<Character, Integer> typeMap = Map.of('S',4, 'H', 3, 'D', 2, 'C', 1);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("JOKER")) break;

            String[] parts = line.split(": ");
            String name = parts[0];
            String[] cards = parts[1].split(", ");

            players.putIfAbsent(name, new HashSet<>());
            players.get(name).addAll(Arrays.asList(cards));
        }
        for (var entry : players.entrySet()) {
            int sum = 0;
            for (String card : entry.getValue()) {
                String power = card.substring(0, card.length() - 1);
                char type = card.charAt(card.length() - 1);
                sum += powerMap.get(power) * typeMap.get(type);
            }
            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }
}

