package Exercise.ContactList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

    private List<Contact> contacts;

    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact){
        contacts.add(contact);
        System.out.println("Contact added: "+ contact);
    }

    public Contact searchContact(String name){
        for (Contact contact : contacts){
            if (contact.getContactName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        System.out.println("Contact not found...");
        return null;
    }

    public void deleteContact(String name){
        Contact contactToDelete = searchContact(name);
        if (contactToDelete != null){
            contacts.remove(contactToDelete);
            System.out.println("Contact deleted: "+ contactToDelete);
        }else {
            System.out.println("Contact not found...");
        }
    }

    public void showContact(){
        if (contacts.isEmpty()){
            System.out.println("Agenda is empty!");
        }else {
            System.out.println("Contacts on Agenda:");
            for (Contact i : contacts){
                System.out.println(i);
            }
        }
    }

    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();


        while (true){
            System.out.println("\nContact Agenda System\n" +
                    "1. Add contacts\n" +
                    "2. Delete contact\n" +
                    "3. Search contact\n" +
                    "4. Show all the contacts\n" +
                    "5. Exit");
            System.out.println("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter the contact name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the phone number: ");
                    String phone = scanner.nextLine();
                    System.out.println("Enter the email contact: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phone, email);
                    agenda.addContact(newContact);
                    break;
                case 2:
                    System.out.println("Enter the name of the contact to delete: ");
                    String nameTodelete = scanner.nextLine();
                    agenda.deleteContact(nameTodelete);
                    break;
                case 3:
                    System.out.println("Enter the name of the contact to search: ");
                    String nameToSearch = scanner.nextLine();
                    Contact foundContact = agenda.searchContact(nameToSearch);
                    if (foundContact != null){
                        System.out.println("Contact found: "+ foundContact);
                    }
                    break;
                case 4:
                    agenda.showContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option... try again");
            }
        }

    }
}
