package service;

import model.Gender;
import model.User;

import java.util.Scanner;

public class MenuController {

    OnlineBank onlineBank;
    Scanner scanner;

    public MenuController() {
        onlineBank = new OnlineBank();
        scanner = new Scanner(System.in);
    }

    public void start() {
        User userFirst = new User("Ann", "Green", Gender.FEMALE, "UA23XXX2582569874123", 1523.05);
        User userSecond = new User("Peter", "Monroe", Gender.MALE, "UA58XXX2136985487521", 5124.85);
        User userThird = new User("Elizabeth", "Wood", Gender.FEMALE, "UA44XXX6325984562111", 100.25);

        User loggedInUser = null;
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("Please, login!");
            System.out.println("Enter your account number: ");
            String accountNumber = scanner.nextLine();

            if (accountNumber.equals(userFirst.getAccountNumber())) {
                loggedIn = onlineBank.login(userFirst);
                loggedInUser = userFirst;
            } else if (accountNumber.equals(userSecond.getAccountNumber())) {
                loggedIn = onlineBank.login(userSecond);
                loggedInUser = userSecond;
            } else if (accountNumber.equals(userThird.getAccountNumber())) {
                loggedIn = onlineBank.login(userThird);
                loggedInUser = userThird;
            } else {
                System.out.println("Invalid account number! Please, try again!");
            }
        }

        while (true) {
            System.out.println("""
                    
                    Choose an option from the menu!
                    1. Credit user
                    2. Debit user
                    3. Show account balance
                    4. Logout
                    """);

            String usersChoice = scanner.nextLine();

            switch (usersChoice) {
                case "1":
                    System.out.println("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    onlineBank.creditUser(loggedInUser, creditAmount);
                    break;
                case "2":
                    System.out.println("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    onlineBank.debitUser(loggedInUser, debitAmount);
                    break;
                case "3":
                    onlineBank.showAccountBalance(loggedInUser);
                    break;
                case "4":
                    onlineBank.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
