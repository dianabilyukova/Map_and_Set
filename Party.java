import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = sc.nextLine();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = sc.nextLine();
        }
        while (true) {
            input = sc.nextLine();
            if (input.equals("END")) break;
            vip.remove(input);
            regular.remove(input);
        }
        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
