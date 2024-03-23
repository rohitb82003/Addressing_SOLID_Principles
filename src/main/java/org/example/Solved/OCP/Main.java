package org.example.Solved.OCP;

// Coffee interface representing the abstraction of a coffee
interface Coffee {
    String getDescription();
    double getPrice();
}

// Base class representing a basic coffee
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getPrice() {
        return 2.0;
    }
}

// Decorator class for adding milk to the coffee
class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with Milk";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 0.5;
    }
}

// Decorator class for adding sugar to the coffee
class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with Sugar";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 0.3;
    }
}

// Coffee machine class responsible for making coffee
class CoffeeMachine {
    public Coffee makeCoffee() {
        return new BasicCoffee();
    }
}

// Test class to demonstrate the usage
public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        // Making a basic coffee
        Coffee basicCoffee = coffeeMachine.makeCoffee();
        System.out.println("Description: " + basicCoffee.getDescription());
        System.out.println("Price: $" + basicCoffee.getPrice());

        // Making a coffee with milk
        Coffee coffeeWithMilk = new MilkDecorator(coffeeMachine.makeCoffee());
        System.out.println("\nDescription: " + coffeeWithMilk.getDescription());
        System.out.println("Price: $" + coffeeWithMilk.getPrice());

        // Making a coffee with sugar
        Coffee coffeeWithSugar = new SugarDecorator(coffeeMachine.makeCoffee());
        System.out.println("\nDescription: " + coffeeWithSugar.getDescription());
        System.out.println("Price: $" + coffeeWithSugar.getPrice());

        // Making a coffee with both milk and sugar
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(new MilkDecorator(coffeeMachine.makeCoffee()));
        System.out.println("\nDescription: " + coffeeWithMilkAndSugar.getDescription());
        System.out.println("Price: $" + coffeeWithMilkAndSugar.getPrice());
    }
}
