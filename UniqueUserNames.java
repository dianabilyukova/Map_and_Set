import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUserNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String username = sc.nextLine();
            usernames.add(username);
        }
        for (String name : usernames) {
            System.out.println(name);
        }
    }
}
