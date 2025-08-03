import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (String num : sc.nextLine().split(" ")) {
            first.add(Integer.parseInt(num));
        }
        for (String num : sc.nextLine().split(" ")) {
            second.add(Integer.parseInt(num));
        }
        for (int round = 0; round < 50; round++) {
            if (first.isEmpty() || second.isEmpty()) break;

            int firstCard = first.iterator().next();
            first.remove(firstCard);

            int secondCard = second.iterator().next();
            second.remove(firstCard);

            if (firstCard > secondCard) {
                first.add(firstCard);
                first.add(secondCard);
            } else if (secondCard > firstCard) {
                second.add(firstCard);
                second.add(secondCard);
            }
        }
        if (first.size() > second.size()) {
            System.out.println("First Player win!");
        } else if (second.size() > first.size()) {
            System.out.println("Second Player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
