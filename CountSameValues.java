import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSameValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");

        Map<Double, Integer> countMap = new LinkedHashMap<>();

        for (String num : numbers) {
            double value = Double.parseDouble(num);
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }

        for (var entry : countMap.entrySet()) {
            System.out.printf("%.1f - %d times%n", entry.getKey(), entry.getValue());
        }
    }
}
