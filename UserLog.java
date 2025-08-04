import java.util.*;

public class UserLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("end")) break;

            String[] parts = line.split(" ");
            String ip = parts[0].split("=")[1];
            String user = parts[2].split("=")[1];

            logs.putIfAbsent(user, new LinkedHashMap<>());
            logs.get(user).put(ip, logs.get(user).getOrDefault(ip, 0) + 1);
        }
        for (var entry : logs.entrySet()) {
            System.out.println(entry.getKey() + ":");
            List<String> ipEntries = new ArrayList<>();
            for (var ipEntry : entry.getValue().entrySet()) {
                ipEntries.add(ipEntry.getKey() + " => " + ipEntry.getValue());
            }
            System.out.println(String.join(", ", ipEntries) + ".");
        }
    }
}
