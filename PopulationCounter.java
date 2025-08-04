import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("report")) break;

            String[] parts = line.split("\\|");
            String city = parts[0];
            String country = parts[1];
            long population = Long.parseLong(parts[2]);

            data.putIfAbsent(country, new LinkedHashMap<>());
            data.get(country).put(city, population);
        }
        data.entrySet().stream().sorted((a, b) -> Long.compare(
                b.getValue().values().stream().mapToLong(Long::longValue).sum(),
                a.getValue().values().stream().mapToLong(Long::longValue).sum()
                )
        ).forEach(entry -> {
            long totalPop = entry.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)%n", entry.getKey(), totalPop);

            entry.getValue().entrySet().stream()
                    .sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                    .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        });
    }
}
