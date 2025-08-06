import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String name = parts[1];
            int damage = parts[2].equals("null") ? 45 : Integer.parseInt(parts[2]);
            int health = parts[3].equals("null") ? 250 : Integer.parseInt(parts[3]);
            int armor = parts[4].equals("null") ? 10 : Integer.parseInt(parts[4]);

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new int[]{damage, health, armor});
        }
        for (var typeEntry : dragons.entrySet()) {
            double avgDamage = 0, avgHealth = 0, avgArmor = 0;
            for (var stats : typeEntry.getValue().values()) {
                avgDamage += stats[0];
                avgHealth += stats[1];
                avgArmor += stats[2];
            }
            int count = typeEntry.getValue().size();
            avgDamage /= count;
            avgHealth /= count;
            avgArmor /= count;

            System.out.printf("%s::(%.2f/%.2f/%2f)%n", typeEntry.getKey(), avgDamage, avgHealth, avgArmor);

            for (var dragonEntry : typeEntry.getValue().entrySet()) {
                int[] stats = dragonEntry.getValue();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragonEntry.getKey(), stats[0], stats[1], stats[2]);
            }
        }
    }
}
