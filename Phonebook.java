import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("search")) break;

            String[] parts = input.split("-");
            phonebook.put(parts[0], parts[1]);
        }
        while (true) {
            String name = sc.nextLine();
            if (name.equals("stop")) break;

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
        }
    }
}
