import java.util.*;

public class CatapultAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====== Catapult Attack Game =====");
        System.out.print("Enter number of waves: ");
        int waveCount = Integer.parseInt(sc.nextLine());

        System.out.println("Enter initial wall strengths (space-separated): ");
        LinkedList<Integer> walls = new LinkedList<>();
        String[] wallInput = sc.nextLine().split(" ");
        for (String wall : wallInput) {
            walls.add(Integer.parseInt(wall));
        }
        List<List<Integer>> remainingRocks = new ArrayList<>();

        for (int wave = 1; wave <= waveCount; wave++) {
            System.out.printf("--- Wave %d ---\n", wave);
            if (wave % 3 == 0) {
                System.out.println("Spartans build new wall (enter velue): ");
                int newWall = Integer.parseInt(sc.nextLine());
                walls.addLast(newWall);
            }
            System.out.println("Enter rocks for this wave (space-separated): ");
            String[] rockInput = sc.nextLine().split(" ");
            Stack<Integer> rocks = new Stack<>();
            for (String rock : rockInput) {
                rocks.push(Integer.parseInt(rock));
            }
            while (!rocks.isEmpty() && !walls.isEmpty()) {
                int rock = rocks.pop();
                int wall = walls.pollFirst();

                if (rock > wall) {
                    rock -= wall;
                    rocks.push(rock);
                } else if (wall > rock) {
                    wall -= rock;
                    walls.addFirst(wall);
                }
            }
            if (walls.isEmpty()) break;
        }
        if (walls.isEmpty()) {
            List<String> leftRocks = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                if (!Character.isDigit(line.charAt(0))) continue;
                String[] parts = line.split(" ");
                for (String part : parts) {
                    leftRocks.add(part);
                }
            }
            System.out.println("Rocks left: " + String.join(", ", leftRocks));
        } else {
            System.out.println("Walls left: ");
            System.out.println(String.join(", ", walls.stream().map(String::valueOf).toList()));
        }
    }


}
