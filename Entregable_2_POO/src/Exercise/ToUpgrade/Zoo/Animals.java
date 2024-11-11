package Exercise.ToUpgrade.Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animals {

    // Base Animal class
    public static class Animal {
        private String name;

        // Constructor
        public Animal(String name) {
            this.name = name;
        }

        // Polymorphic method to make a sound
        public void makeSound() {
            System.out.println(name + " makes a sound.");
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }
    }

    // Dog subclass
    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(getName() + " barks: Woof! Woof!");
        }
    }

    // Cat subclass
    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(getName() + " meows: Meow! Meow!");
        }
    }

    // Bird subclass
    public static class Bird extends Animal {
        public Bird(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(getName() + " chirps: Tweet! Tweet!");
        }
    }

    // List to store all animals
    private static List<Animal> zooAnimals = new ArrayList<>();

    // Main method to manage animals
    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nZoo Animal Sound System\n" +
                    "1. Add a Dog\n" +
                    "2. Add a Cat\n" +
                    "3. Add a Bird\n" +
                    "4. Show all animals and their sounds\n" +
                    "5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    zooAnimals.add(createAnimal(scanner, "Dog"));
                    break;
                case 2:
                    zooAnimals.add(createAnimal(scanner, "Cat"));
                    break;
                case 3:
                    zooAnimals.add(createAnimal(scanner, "Bird"));
                    break;
                case 4:
                    displayAnimals();
                    break;
                case 5:
                    System.out.println("Exiting the zoo animal system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to create an animal based on type
    private static Animal createAnimal(Scanner scanner, String type) {
        System.out.print("Enter the animal's name: ");
        String name = scanner.nextLine();

        switch (type) {
            case "Dog":
                return new Dog(name);
            case "Cat":
                return new Cat(name);
            case "Bird":
                return new Bird(name);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }

    // Method to display all animals and their sounds
    private static void displayAnimals() {
        if (zooAnimals.isEmpty()) {
            System.out.println("No animals in the zoo.");
        } else {
            System.out.println("Animals in the zoo:");
            for (Animal animal : zooAnimals) {
                System.out.println(animal);
                animal.makeSound(); // Polymorphic call to makeSound()
            }
        }
    }
}
