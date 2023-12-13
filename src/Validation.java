import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);

    public static double takeDouble() {
        double result;
        while (true) {
            try {
                System.out.print("Enter a double: ");
                result = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine(); // Clear the buffer
            }
        }
        scanner.nextLine(); // Consume the newline character
        return result;
    }

    public static int takeInt() {
        int result;
        while (true) {
            try {
                System.out.print("Enter an integer: ");
                result = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the buffer
            }
        }
        scanner.nextLine(); // Consume the newline character
        return result;
    }

    public static String takeString() {
        String result;
        while (true) {
            System.out.print("Enter a string: ");
            result = scanner.nextLine();
            if (!result.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a non-empty string.");
            }
        }
        return result;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
