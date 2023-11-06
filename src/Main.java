import java.util.ArrayList;
import java.util.Scanner;

class Lab_11_Listmaker {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            System.out.println("Main Menu:");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");

            String choice = SafeInput.getRegExString("[AaDdPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItemToList();
                    break;
                case "D":
                    deleteItemFromList();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (getYNConfirm("Are you sure you want to quit? (Y/N): ")) {
                        quit = true;
                    }
                    break;
            }
        }
    }

    private static void addItemToList() {
        System.out.print("Enter an item to add: ");
        String item = scanner.nextLine();
        itemList.add(item);
        System.out.println("Item added to the list.");
    }

    private static void deleteItemFromList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current list:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }

        int itemNumber = SafeInput.getRangedInt("Enter the item number to delete: ", 1, itemList.size());
        itemList.remove(itemNumber - 1);
        System.out.println("Item removed from the list.");
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current list:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    private static boolean getYNConfirm(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        return input.equalsIgnoreCase("Y");
    }
}
