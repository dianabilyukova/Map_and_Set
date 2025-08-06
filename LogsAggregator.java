import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> durations = new TreeMap<>();
        Map<String, Set<String>> userIPs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String ip = parts[0];
            String user = parts[1];
            int duration = Integer.parseInt(parts[2]);

            durations.put(user, durations.getOrDefault(user, 0) + duration);

            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);
        }
        for (String user : durations.keySet()) {
            System.out.printf("%s : %d %s%n", user, durations.get(user), userIPs.get(user));
        }
    }
}
