import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizes = sc.nextLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            first.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            second.add(Integer.parseInt(sc.nextLine()));
        }
        first.retainAll(second);

        for (int num : first) {
            System.out.println(num + " ");
        }
    }
}
