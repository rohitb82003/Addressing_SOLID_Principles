package org.example.Solved.LSP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Base class representing a pet
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

// Subclass representing a pet with medical history
class PetWithMedicalHistory extends Pet {
    private Map<String, String> medicalHistory;

    public PetWithMedicalHistory(String name, String species) {
        super(name, species);
        this.medicalHistory = new HashMap<>();
    }

    // Method to add a disease to the medical history
    public void addDisease(String disease, String notes) {
        medicalHistory.put(disease, notes);
    }

    // Method to remove a disease from the medical history
    public void removeDisease(String disease) {
        medicalHistory.remove(disease);
    }

    // Method to display medical history
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

// Class representing the database for vets
class VetDatabase {
    private Map<String, PetWithMedicalHistory> petDatabase;
    private Scanner scanner;

    public VetDatabase() {
        this.petDatabase = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add a pet to the database
    public void addPet(String name, String species) {
        PetWithMedicalHistory pet = new PetWithMedicalHistory(name, species);
        petDatabase.put(name, pet);
        System.out.println("Pet added to the database.");
    }

    // Method to add disease to a pet's medical history
    public void addDiseaseToPet(String name, String disease, String notes) {
        PetWithMedicalHistory pet = petDatabase.get(name);
        if (pet != null) {
            pet.addDisease(disease, notes);
            System.out.println("Disease added to the pet's medical history.");
        } else {
            System.out.println("Pet not found in the database.");
        }
    }

    // Method to remove a disease from a pet's medical history
    public void removeDiseaseFromPet(String name, String disease) {
        PetWithMedicalHistory pet = petDatabase.get(name);
        if (pet != null) {
            pet.removeDisease(disease);
            System.out.println("Disease removed from the pet's medical history.");
        } else {
            System.out.println("Pet not found in the database.");
        }
    }

    // Method to display a pet's details and medical history
    public void displayPetDetails(String name) {
        PetWithMedicalHistory pet = petDatabase.get(name);
        if (pet != null) {
            System.out.println("Pet Details:");
            System.out.println(pet);
            pet.displayMedicalHistory();
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
            System.out.println("3. Remove Disease from Pet's Medical History");
            System.out.println("4. Display Pet Details");
            System.out.println("5. Exit");
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
                    System.out.print("Enter disease name to remove: ");
                    disease = scanner.nextLine();
                    vetDB.removeDiseaseFromPet(petName, disease);
                    break;
                case 4:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    vetDB.displayPetDetails(petName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
