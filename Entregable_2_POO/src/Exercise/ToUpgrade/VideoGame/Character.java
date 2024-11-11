package Exercise.ToUpgrade.VideoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character {
    private String name;
    private int level;

    // Constructor
    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // Method to attack (polymorphic method)
    public void attack() {
        System.out.println(name + " attacks!");
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    public static class Warrior extends Character {
        public Warrior(String name, int level) {
            super(name, level);
        }

        @Override
        public void attack() {
            System.out.println(getName() + " swings a sword with powerful strength!");
        }
    }

    public static class Mage extends Character {
        public Mage(String name, int level) {
            super(name, level);
        }

        @Override
        public void attack() {
            System.out.println(getName() + " casts a devastating fireball!");
        }
    }

    public static class Necromancer extends Character {
        public Necromancer(String name, int level) {
            super(name, level);
        }

        @Override
        public void attack() {
            System.out.println(getName() + " summons undead minions to attack!");
        }
    }

    public static class Tank extends Character {
        public Tank(String name, int level) {
            super(name, level);
        }

        @Override
        public void attack() {
            System.out.println(getName() + " charges with a shield, absorbing all damage!");
        }
    }

    public static class Assassin extends Character {
        public Assassin(String name, int level) {
            super(name, level);
        }

        @Override
        public void attack() {
            System.out.println(getName() + " strikes swiftly from the shadows!");
        }
    }


    private static List<Character> characters = new ArrayList<>(); // List to store all characters

    // Common attributes and methods for all characters

    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVideo Game Character System\n" +
                    "1. Create a Warrior\n" +
                    "2. Create a Mage\n" +
                    "3. Create a Necromancer\n" +
                    "4. Create a Tank\n" +
                    "5. Create an Assassin\n" +
                    "6. Show all characters and their attacks\n" +
                    "7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    characters.add(createCharacter(scanner, "Warrior"));
                    break;

                case 2:
                    characters.add(createCharacter(scanner, "Mage"));
                    break;

                case 3:
                    characters.add(createCharacter(scanner, "Necromancer"));
                    break;

                case 4:
                    characters.add(createCharacter(scanner, "Tank"));
                    break;

                case 5:
                    characters.add(createCharacter(scanner, "Assassin"));
                    break;

                case 6:
                    displayCharacters();
                    break;

                case 7:
                    System.out.println("Exiting the character system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to create a character based on type
    private static Character createCharacter(Scanner scanner, String type) {
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        System.out.print("Enter character level: ");
        int level = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (type) {
            case "Warrior":
                return new Warrior(name, level);
            case "Mage":
                return new Mage(name, level);
            case "Necromancer":
                return new Necromancer(name, level);
            case "Tank":
                return new Tank(name, level);
            case "Assassin":
                return new Assassin(name, level);
            default:
                throw new IllegalArgumentException("Unknown character type: " + type);
        }
    }

    // Method to display all characters and their attacks
    private static void displayCharacters() {
        if (characters.isEmpty()) {
            System.out.println("No characters in the system.");
        } else {
            System.out.println("Characters in the system:");
            for (Character character : characters) {
                System.out.println(character);
                character.attack();
            }
        }
    }
}
