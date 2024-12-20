package fitness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Fitness Account Management ===");
            System.out.println("1. Create Account");
            System.out.println("2. Update Dietary Preferences");
            System.out.println("3. Delete Account");
            System.out.println("4. View Profile");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user = createAccount(scanner);
                    break;
                case 2:
                    if (user != null) {
                        updateDietaryPreferences(scanner, user);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 3:
                    if (user != null) {
                        deleteAccount(user);
                        user = null;
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 4:
                    if (user != null) {
                        viewProfile(user);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static User createAccount(Scanner scanner) {
        User user = new User();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter fitness goals: ");
        String fitnessGoals = scanner.nextLine();

        System.out.print("Enter dietary preferences: ");
        String dietaryPreferences = scanner.nextLine();

        user.setAge(age);
        user.setFitnessGoals(fitnessGoals);
        user.setDietaryPreferences(dietaryPreferences);

        String result = user.createAccount();
        if (user.getId() != null) {
            System.out.println(result);
        } else {
            System.out.println("Failed to create account: " + result);
        }

        return user;
    }

    private static void updateDietaryPreferences(Scanner scanner, User user) {
        System.out.print("Enter new dietary preferences: ");
        String dietaryPreferences = scanner.nextLine();
        user.setDietaryPreferences(dietaryPreferences);

        String result = user.updateDietaryPreferences();
        System.out.println(result);
    }

    private static void deleteAccount(User user) {
        user.deleteAccount();
        String result = user.confirmDeleteAccount();
        System.out.println(result);
    }

    private static void viewProfile(User user) {
        System.out.println("\n=== User Profile ===");
        System.out.println("Age: " + user.getAge());
        System.out.println("Fitness Goals: " + user.getFitnessGoals());
        System.out.println("Dietary Preferences: " + user.getDietaryPreferences());
        System.out.println("Account ID: " + (user.getId() != null ? user.getId() : "Not created"));
    }
}


