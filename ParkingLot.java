import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) break;

            String[] parts = input.split(", ");
            String direction = parts[0];
            String carNumber = parts[1];

            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
