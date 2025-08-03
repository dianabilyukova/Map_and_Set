import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Double> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String[] gradesStr = sc.nextLine().split(" ");
            double sum = 0;
            for (String g : gradesStr) {
                sum += Double.parseDouble(g);
            }
            double avg = sum / gradesStr.length;
            students.put(name, avg);
        }

        for (var entry : students.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}