# Single Responsibility Principle (SRP)
The Single Responsibility Principle states that a class should have only one reason to change, meaning that it should have only one responsibility or concern. This principle promotes better code organization, maintainability, and reusability.

In our project, we adhere to SRP by designing classes with a single responsibility:

- Menu: Manages the menu of a restaurant.
- Dish: Represents a dish with its name and price.
- MenuManager: Handles user interaction with the menu, such as adding or removing dishes.
VetDatabase: Manages the database of pets for veterinarians, including adding pets, adding diseases to a pet's medical history, and displaying pet details.
Each class focuses on a specific aspect of functionality, such as managing dishes or pets, without mixing unrelated concerns. This ensures that changes to one aspect of the system do not affect other unrelated parts, promoting code maintainability and flexibility.

# Liskov Substitution Principle (LSP)
The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program. In other words, derived classes must be substitutable for their base classes without altering the desirable properties of the program.

In our project, we adhere to LSP by ensuring that subclasses can be used interchangeably with their base classes:

Pet: Represents a basic pet with name and species.
PetWithMedicalHistory: Extends Pet to add medical history functionality.
Bird: Subclass of Pet, representing a bird with additional functionality (violating LSP in the example provided).
By using polymorphism, methods in the VetDatabase class work with instances of both Pet and PetWithMedicalHistory, allowing for flexibility and ease of extension without affecting the behavior of the program. However, the provided example of Bird violates LSP by adding a method (fly()) specific to birds, which may not be applicable to all pets.

# Open/Closed Principle (OCP)
The Open/Closed Principle states that software entities (classes, modules, functions) should be open for extension but closed for modification. In this project, the Coffee interface is open for extension through decorators (MilkDecorator, SugarDecorator) but closed for modification.

We can introduce new functionalities (e.g., adding flavors, syrups) by creating new decorators without altering existing code. This promotes code reuse and minimizes the risk of introducing bugs when extending functionality.
