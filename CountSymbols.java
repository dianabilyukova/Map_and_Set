import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        Map<Character, Integer> counts = new TreeMap<>();

        for (char ch : text.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        for (var entry : counts.entrySet()) {
            System.out.printf("%c : %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
