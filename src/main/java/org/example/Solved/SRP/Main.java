package org.example.Solved.SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Menu {
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(int index) {
        if (index >= 0 && index < dishes.size()) {
            dishes.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println((i + 1) + ". " + dishes.get(i));
        }
    }
}

class MenuManager {
    private Menu menu;
    private Scanner scanner;

    public MenuManager() {
        this.menu = new Menu();
        this.scanner = new Scanner(System.in);
    }

    public void addDishToMenu() {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dish price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        Dish dish = new Dish(name, price);
        menu.addDish(dish);
        System.out.println("Dish added to menu.");
    }

    public void removeDishFromMenu() {
        menu.displayMenu();
        System.out.print("Enter the number of the dish to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        menu.removeDish(index - 1);
        System.out.println("Dish removed from menu.");
    }

    public void displayMenu() {
        menu.displayMenu();
    }
}

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
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
                    menuManager.addDishToMenu();
                    break;
                case 2:
                    menuManager.removeDishFromMenu();
                    break;
                case 3:
                    menuManager.displayMenu();
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
