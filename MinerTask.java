import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Long> resources = new LinkedHashMap<>();

        while (true) {
            String resource = sc.nextLine();
            if (resource.equals("stop")) break;

            long quantity = Long.parseLong(sc.nextLine());

            resources.put(resource, resources.getOrDefault(resource, 0L) + quantity);
        }
        for (var entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
