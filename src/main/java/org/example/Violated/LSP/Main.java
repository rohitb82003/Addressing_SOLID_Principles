package org.example.Violated.LSP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pet {
    private String name;
    private String species;

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Species: " + species;
    }
}

class PetWithMedicalHistory extends Pet {
    private Map<String, String> medicalHistory;

    public PetWithMedicalHistory(String name, String species) {
        super(name, species);
        this.medicalHistory = new HashMap<>();
    }

    public void addDisease(String disease, String notes) {
        medicalHistory.put(disease, notes);
    }

    public void removeDisease(String disease) {
        medicalHistory.remove(disease);
    }

    public void displayMedicalHistory() {
        System.out.println("Medical History for " + getName() + ":");
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for (Map.Entry<String, String> entry : medicalHistory.entrySet()) {
                System.out.println("Disease: " + entry.getKey() + ", Notes: " + entry.getValue());
            }
        }
    }
}

class Bird extends Pet { // Bird class violates LSP
    public Bird(String name, String species) {
        super(name, species);
    }

    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}

class VetDatabase {
    private Map<String, Pet> petDatabase; // Changed to accept generic Pet instead of PetWithMedicalHistory
    private Scanner scanner;

    public VetDatabase() {
        this.petDatabase = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addPet(String name, String species) {
        Pet pet = new Pet(name, species); // Violation: Not using PetWithMedicalHistory
        petDatabase.put(name, pet);
        System.out.println("Pet added to the database.");
    }

    public void addDiseaseToPet(String name, String disease, String notes) {
        PetWithMedicalHistory pet = (PetWithMedicalHistory) petDatabase.get(name); // Violation: Casting may fail if the pet is not a PetWithMedicalHistory
        if (pet != null) {
            pet.addDisease(disease, notes);
            System.out.println("Disease added to the pet's medical history.");
        } else {
            System.out.println("Pet not found in the database.");
        }
    }

    public void displayPetDetails(String name) {
        Pet pet = petDatabase.get(name); // Violation: Not using PetWithMedicalHistory
        if (pet != null) {
            System.out.println("Pet Details:");
            System.out.println(pet);
        } else {
            System.out.println("Pet not found in the database.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VetDatabase vetDB = new VetDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVet Database");
            System.out.println("1. Add Pet");
            System.out.println("2. Add Disease to Pet's Medical History");
            System.out.println("3. Display Pet Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String petName = scanner.nextLine();
                    System.out.print("Enter pet species: ");
                    String species = scanner.nextLine();
                    vetDB.addPet(petName, species);
                    break;
                case 2:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    System.out.print("Enter disease name: ");
                    String disease = scanner.nextLine();
                    System.out.print("Enter notes: ");
                    String notes = scanner.nextLine();
                    vetDB.addDiseaseToPet(petName, disease, notes);
                    break;
                case 3:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    vetDB.displayPetDetails(petName);
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
