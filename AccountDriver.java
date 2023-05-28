//*************************************************************************
//AccountDriver.java
//Date: 03/29/2023
//Author: David Taylor
//Class: CIT 149–19Z1–78178
//Instructor: Krishna Nandanoor
//Purpose: Develop a Java application where you will create a user-defined Java class to maintain data about a user’s
// credentials to log into an application or system. This will include a user’s name and password and an additional
// piece of data to help with encryption. We will visit the Caesar cipher again.
//*************************************************************************

import java.util.Scanner;
public class AccountDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ////////////Test the constructor////////////
        System.out.println("\n---Constructors are being tested---");

        System.out.println("\nEnter a username and password.");

        System.out.print("Username: ");
        String nameInput = scan.nextLine();

        System.out.print("Password: ");
        String passwordInput = scan.nextLine();

        UserAccount userTest = new UserAccount(nameInput, passwordInput);

        userTest.toString();

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEnter a username and password.");

            System.out.print("Username: ");
            nameInput = scan.nextLine();

            System.out.print("Password: ");
            passwordInput = scan.nextLine();

            UserAccount userLoop = new UserAccount(nameInput, passwordInput);

            System.out.println("User #" + i);
            userLoop.toString();
        }

        ////////////Test the accessors////////////
        System.out.println("\n---Accessors are being tested---");
        UserAccount userJohn = new UserAccount("John Smith", "Zab98W55k");

        System.out.println(userJohn.getUserName());
        System.out.println(userJohn.getPassword());

        ////////////Test the mutator////////////
        System.out.println("\n---Mutators are being tested---");

        System.out.print("\nInput new password for John Smith: ");
        String testPassword = scan.nextLine();
        userJohn.setPassword(testPassword);

        System.out.print("\nnew password: " + userJohn.getPassword());

        ////////////Test the encrypt method////////////
        System.out.println("\n\n---Encryption method is being tested---");

        System.out.println("\nBefore Encryption");
        System.out.println(userJohn.getUserName());
        System.out.println(userJohn.getPassword());

        System.out.print("\nInput a shift amount (1-19 are valid values): ");
        int testShift = scan.nextInt();
        userJohn.encrypt(testShift);

        System.out.println("\nAfter Encryption - first time");
        System.out.println(userJohn.getUserName());
        System.out.println(userJohn.getPassword());

        System.out.print("\nInput a shift amount (1-19 are valid values): ");
        testShift = scan.nextInt();
        userJohn.encrypt(testShift);

        System.out.println("\nAfter Encryption - second time");
        System.out.println(userJohn.getUserName());
        System.out.println(userJohn.getPassword());

        ////////////Test the decrypt method////////////
        System.out.println("\n---Decryption method is being tested---");

        UserAccount userSally = new UserAccount("Sally McIntosh", "B1N8hop10");

        System.out.println("\nBefore Encryption");
        userSally.toString();

        System.out.print("\nInput a shift amount (1-19 are valid values): ");
        testShift = scan.nextInt();
        userSally.encrypt(testShift);

        System.out.println("\nAfter Encryption");
        userSally.toString();

        System.out.println("Encryption status: " + userSally.isEncrypted());

        userSally.decrypt();
        System.out.println("\nAfter Decryption");
        userSally.toString();

        userSally.decrypt();
        System.out.println("\nAfter Decryption");
        userSally.toString();

        System.out.println("Encryption status: " + userSally.isEncrypted());

        System.out.println("\nTesting Ended");
    }
}