package Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Person {

    public enum GenreE {
        FEMALE, MALE
    }

    private String name;
    private int age;
    private GenreE genre;

    public Person(String name, int age, GenreE genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public String compareAge(Person otherPerson){
        if (age > otherPerson.age){
            return name + " is older than "+ otherPerson.name;
        } else if (age < otherPerson.age) {
            return name + " is younger than " +otherPerson.name;
        } else {
            return name + " and " + otherPerson.name + " are the same age";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Genre: " + genre;
    }

    public static void main(Object o){
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();


        System.out.println("Enter the number of persons to compare: ");
        int nPersons = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nPersons; i++){
            System.out.println("Enter name for person #"+ (i+1)+": ");
            String name = scanner.nextLine();

            System.out.println("Enter age for person #"+ (i+1)+": ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter genre (FEMALE/MALE) for person #"+(i+1)+": ");
            String genreInput = scanner.nextLine().toUpperCase();
            GenreE genre = GenreE.valueOf(genreInput);

            Person person = new Person(name, age, genre);
            people.add(person);
        }

        System.out.println("\nComparing ages between people:");
        for (int i = 0; i<people.size(); i++){
            for (int j = i+1; j < people.size(); j++){
                System.out.println(people.get(i).compareAge(people.get(j)));
            }
        }

        // Optional: Sort people list by age from youngest to oldest
        people.sort(Comparator.comparingInt(p -> p.age));

        // Display sorted list
        System.out.println("\nPeople sorted by age (from youngest to oldest):");
        for (Person i : people) { // Loop through an ArrayList
            System.out.println(i);
        }



    }
}
