import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        String obtainedItem = null;

        while (obtainedItem == null) {
            String[] parts = sc.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < parts.length; i += 2) {
                int qty = Integer.parseInt(parts[i]);
                String material = parts[i +1];

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + qty);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("shards")) obtainedItem = "Shadowmourne";
                        else if (material.equals("fragments")) obtainedItem = "Valanyr";
                        else if (material.equals("motes")) obtainedItem = "Dragonwrath";
                        break;
                    }
                } else {
                    junk.put(material, junk.getOrDefault(material, 0) + qty);
                }
            }
        }
        System.out.println(obtainedItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    if (cmp == 0) return a.getKey().compareTo(b.getKey());
                    return cmp;
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        junk.forEach((mat, qty) -> System.out.printf("%s: %d%n", mat, qty));
    }
}
