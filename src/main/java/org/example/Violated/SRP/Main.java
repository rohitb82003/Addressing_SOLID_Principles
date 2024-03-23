import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private List<String> dishes;
    private Scanner scanner;

    public Menu() {
        this.dishes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addDish() {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        dishes.add(name);
        System.out.println("Dish added to menu.");
    }

    public void removeDish() {
        displayMenu();
        System.out.print("Enter the name of the dish to remove: ");
        String name = scanner.nextLine();
        if (dishes.remove(name)) {
            System.out.println("Dish removed from menu.");
        } else {
            System.out.println("Dish not found.");
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println((i + 1) + ". " + dishes.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Management System");
            System.out.println("1. Add Dish to Menu");
            System.out.println("2. Remove Dish from Menu");
            System.out.println("3. Display Menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    menu.addDish();
                    break;
                case 2:
                    menu.removeDish();
                    break;
                case 3:
                    menu.displayMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
