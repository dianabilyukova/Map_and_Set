import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(.+) @(.+) (\\d+) (\\d+)");

        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) break;

            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) continue;

            String singer = matcher.group(1);
            String venue = matcher.group(2);
            long price = Long.parseLong(matcher.group(3));
            long count = Long.parseLong(matcher.group(4));
            long money = price * count;

            venues.putIfAbsent(venue, new LinkedHashMap<>());
            venues.get(venue).put(singer, venues.get(venue).getOrDefault(singer, 0L) + money);
        }
        for (var venueEntry : venues.entrySet()) {
            System.out.println(venueEntry.getKey());
            venueEntry.getValue().entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .forEach(e -> System.out.printf("# %s -> %d%n", e.getKey(), e.getValue()));
        }
    }
}
