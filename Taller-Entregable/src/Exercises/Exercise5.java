package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {

    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

         class User{
            private String userName;
            private String password;
            private String mail;

             public User(String userName, String password, String mail) {
                 this.userName = userName;
                 this.password = password;
                 this.mail = mail;
             }

             public String getUserName() {
                 return userName;
             }

             public String getPassword() {
                 return password;
             }

             public String getMail() {
                 return mail;
             }

             public void setUserName(String userName){
                 this.userName = userName;
             }

             public void setPassword(String password) {
                 this.password = password;
             }

             public void setMail(String mail) {
                 this.mail = mail;
             }

             public boolean validatePassword(){
                 return password.length() >= 8 && password.matches(".*[A-Z]*.") && password.matches(".*\\d*.");
             }

             @Override
             public String toString() {
                 return "User{" +
                         "userName='" + userName + '\'' +
                         ", password='" + password + '\'' +
                         ", mail='" + mail + '\'' +
                         '}';
             }
         }

        ArrayList<User> users = new ArrayList<>();

         boolean next5 = false;

        while (!next5){
            System.out.println("Enter the username: ");
            String username = scanner.nextLine();

            System.out.println("Enter a Mail: ");
            String mail = scanner.nextLine();


            do {
                System.out.println("Enter the password (8 characters / one uppercase / one Number): ");
                String password = scanner.nextLine();

                User tUser = new User(username, password, mail);
                if (tUser.validatePassword()){
                    users.add(tUser);
                    break;
                }else {
                    System.out.println("Invalid password format...");
                }
            }while (true);

            System.out.print("Do you want to register another user? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                next5 = true;
            }
        }

        System.out.println("\n Registered users:");
        users.forEach((user -> System.out.println(user)));

    }
}
