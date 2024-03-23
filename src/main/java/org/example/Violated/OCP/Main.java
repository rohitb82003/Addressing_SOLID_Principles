package org.example.Violated.OCP;

// Coffee class representing a basic coffee
class Coffee {
    protected String description;
    protected double price;

    public Coffee() {
        this.description = "Basic Coffee";
        this.price = 2.0;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

// Class representing a coffee with milk
class CoffeeWithMilk extends Coffee {
    public CoffeeWithMilk() {
        this.description = "Coffee with Milk";
        this.price = 2.5; // Price of basic coffee + milk
    }
}

// Class representing a coffee with sugar
class CoffeeWithSugar extends Coffee {
    public CoffeeWithSugar() {
        this.description = "Coffee with Sugar";
        this.price = 2.3; // Price of basic coffee + sugar
    }
}

// Test class to demonstrate the usage
    public class Main {
    public static void main(String[] args) {
        Coffee basicCoffee = new Coffee();
        System.out.println("Description: " + basicCoffee.getDescription());
        System.out.println("Price: $" + basicCoffee.getPrice());

        // Violation of OCP: Modifying existing code when adding new functionality
        Coffee coffeeWithMilk = new CoffeeWithMilk();
        System.out.println("\nDescription: " + coffeeWithMilk.getDescription());
        System.out.println("Price: $" + coffeeWithMilk.getPrice());

        // Violation of OCP: Modifying existing code when adding new functionality
        Coffee coffeeWithSugar = new CoffeeWithSugar();
        System.out.println("\nDescription: " + coffeeWithSugar.getDescription());
        System.out.println("Price: $" + coffeeWithSugar.getPrice());
    }
}
