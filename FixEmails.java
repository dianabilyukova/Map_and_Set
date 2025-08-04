import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        while (true) {
            String name = sc.nextLine();
            if (name.equals("stop")) break;

            String email = sc.nextLine();
            String lowerEmail = email.toLowerCase();

            if (!(lowerEmail.endsWith(".us")) || lowerEmail.endsWith(".uk") || lowerEmail.endsWith(".com")) {
                emails.put(name, email);
            }
        }
        for (var entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
