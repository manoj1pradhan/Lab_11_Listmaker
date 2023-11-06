import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SafeInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getRegExString(String regex) {
        String input;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        do {
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!matcher.matches());
        return input;
    }

    public static int getRangedInt(String message, int min, int max) {
        int value;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print(message);
                scanner.next();
            }
            value = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (value < min || value > max) {
                System.out.println("Value out of range. Please enter a value between " + min + " and " + max + ".");
            }
        } while (value < min || value > max);
        return value;
    }

    public static boolean getYNConfirm(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
        return input.equalsIgnoreCase("Y");
    }
}
