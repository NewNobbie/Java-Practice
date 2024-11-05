package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise7 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> userName = new ArrayList<>();
        ArrayList<Boolean> books = new ArrayList<>();
        int option = 0;

        do {

            System.out.println("choose an option: 1. Book, 2. cancel book, 0. leave");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Enter your name for book");
                String name = scanner.nextLine();

                userName.add(name);
                books.add(true);

                show(userName, books);
            }else if( option == 2){

                show(userName, books);
                System.out.println("Enter the number of your book for cancel: ");

                int numCancel = scanner.nextInt();
                userName.remove(numCancel);
                books.remove(numCancel);

                System.out.println("Your book was cancel");
                show(userName, books);
            }
        } while (option != 0);
    }

    public static void show(ArrayList<String> userName,  ArrayList<Boolean> books ){
        System.out.println("------------------------------");
        System.out.println("The books are: ");
        for (int i = 0; i < userName.size(); i++) {
            System.out.println( i+1 + ". Book's name: "+ userName.get(i)+", book: "+ books.get(i));
        }
        System.out.println("------------------------------");

    }

}
