package service;

import model.User;

public class OnlineBank {
    private User loggedInUser;

    public boolean login(User user) {
        if (loggedInUser == null) {
            loggedInUser = user;
            System.out.println("Welcome to Online Bank! You logged in successfully!");
            return true;
        } else {
            System.out.println("Someone is already using an Online Bank. Please, log in later! Thank you!");
            return false;
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("You logged out successfully!");
    }

    public void showAccountBalance(User user) {
        if (loggedInUser == user) {
            double accountBalance = user.getAccountBalance();
            System.out.println("Your Account balance: " + accountBalance);
        } else {
            System.out.println("You are not logged in. Please login to use Online Bank!");
        }
    }

    public void creditUser(User user, double amount) {
        if (loggedInUser == user) {
            double accountBalance = user.getAccountBalance();
            user.setAccountBalance(accountBalance + amount);
            System.out.println("Credit was successful!");
        } else {
            System.out.println("You are not logged in. Please login to use Online Bank!");
        }
    }

    public void debitUser(User user, double amount) {
        if (loggedInUser == user) {
            double accountBalance = user.getAccountBalance();
            if (accountBalance >= amount) {
                user.setAccountBalance(accountBalance - amount);
                System.out.println("Debit was successful!");
            } else {
                System.out.println("You don't have enough amount on your account.");
            }
        } else {
            System.out.println("You are not logged in. Please login to use Online Bank!");
        }
    }

}
