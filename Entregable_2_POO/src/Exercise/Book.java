package Exercise;

import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private int numberPages;

    public Book(String title, String author, int numberPages) {
        this.title = title;
        this.author = author;
        this.numberPages = numberPages;
    }

    public void showSummary(){
        System.out.println("Summary\n" +
                "-------\n" +
                "- Title: " +title+
                "- Author: "+author);
    }

    public void sizeBook(){
        if (numberPages > 300){
            System.out.println("The book need a considerable time to be read... +300 pages");
        }else {
            System.out.println("The book should be easy to read... -300 pages");
        }
    }

    public static void main(Object o){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to one-book at time\n" +
                "Enter the title: ");
        String title = scanner.nextLine();

        System.out.println("Enter the author: ");
        String author = scanner.nextLine();

        System.out.println("Enter the number of pages: ");
        int pages = scanner.nextInt();

        Book book = new Book(title, author, pages);

        book.showSummary();

        book.sizeBook();


    }
}
