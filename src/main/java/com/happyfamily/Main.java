package com.happyfamily;

import com.happyfamily.controller.FamilyController;
import com.happyfamily.dao.impl.CollectionFamilyDAO;
import com.happyfamily.model.*;
import com.happyfamily.service.FamilyService;

import com.happyfamily.exceptions.FamilyOverFlowException;

import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

    private static FamilyController familyController;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CollectionFamilyDAO collectionFamilyDao = new CollectionFamilyDAO();
        FamilyService familyService = new FamilyService(collectionFamilyDao);
        familyController = new FamilyController(familyService);

        System.out.println("--- Welcome to the Happy Family Console Application ---");

        displayMenu();
        handleUserInput();

        scanner.close();
        System.out.println("Exiting Happy Family Console Application. Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Load data (reloads families from file)");
        System.out.println("2. Display all families");
        System.out.println("3. Get families bigger than a specified number of members");
        System.out.println("4. Get families less than a specified number of members");
        System.out.println("5. Count families with a specified number of members");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by its index");
        System.out.println("8. Edit a family by its index");
        System.out.println("9. Remove all children older than a specified age");
        System.out.println("10. Save data (saves all current families to file)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserInput() {
        while (true) {
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next();
                displayMenu();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loadData();
                    break;
                case 2:
                    familyController.displayAllFamilies();
                    break;
                case 3:
                    getFamiliesBiggerThan();
                    break;
                case 4:
                    getFamiliesLessThan();
                    break;
                case 5:
                    countFamiliesWithMemberNumber();
                    break;
                case 6:
                    createNewFamily();
                    break;
                case 7:
                    deleteFamilyByIndex();
                    break;
                case 8:
                    editFamilyByIndex();
                    break;
                case 9:
                    removeAllChildrenOlderThen();
                    break;
                case 10:
                    saveData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number from 0 to 10.");
                    break;
            }
            displayMenu();
        }
    }

    private static void loadData() {
        System.out.println("Loading data from file...");
        familyController.loadData();
        System.out.println("Data loaded. Current families:");
        familyController.displayAllFamilies();
    }

    private static void saveData() {
        System.out.println("Saving data to file...");
        familyController.saveData();
        System.out.println("Data saved successfully.");
    }

    private static void getFamiliesBiggerThan() {
        System.out.print("Enter the number of members: ");
        try {
            int count = scanner.nextInt();
            scanner.nextLine();
            List<Family> families = familyController.getFamiliesBiggerThan(count);
            if (families.isEmpty()) {
                System.out.println("No families bigger than " + count + " members.");
            } else {
                families.forEach(family -> System.out.println(family.prettyFormat()));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void getFamiliesLessThan() {
        System.out.print("Enter the number of members: ");
        try {
            int count = scanner.nextInt();
            scanner.nextLine();
            List<Family> families = familyController.getFamiliesLessThan(count);
            if (families.isEmpty()) {
                System.out.println("No families less than " + count + " members.");
            } else {
                families.forEach(family -> System.out.println(family.prettyFormat()));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void countFamiliesWithMemberNumber() {
        System.out.print("Enter the number of members to count: ");
        try {
            int count = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Number of families with %d members: %d\n", count, familyController.countFamiliesWithMemberNumber(count));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void createNewFamily() {
        System.out.println("--- Creating New Family ---");
        System.out.print("Enter mother's name: ");
        String mName = scanner.nextLine();
        System.out.print("Enter mother's surname: ");
        String mSurname = scanner.nextLine();
        System.out.print("Enter mother's birth date (DD/MM/YYYY): ");
        String mBirthDateStr = scanner.nextLine();
        System.out.print("Enter mother's IQ: ");
        int mIq = -1;
        try {
            mIq = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for IQ. Please enter a number.");
            scanner.nextLine();
            return;
        }


        System.out.print("Enter father's name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter father's surname: ");
        String fSurname = scanner.nextLine();
        System.out.print("Enter father's birth date (DD/MM/YYYY): ");
        String fBirthDateStr = scanner.nextLine();
        System.out.print("Enter father's IQ: ");
        int fIq = -1;
        try {
            fIq = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for IQ. Please enter a number.");
            scanner.nextLine();
            return;
        }

        try {
            long mBirthDate = Human.parseDateToMillis(mBirthDateStr);
            long fBirthDate = Human.parseDateToMillis(fBirthDateStr);

            Human mother = new Woman(mName, mSurname, mBirthDate, mIq, null, new HashMap<>());
            Human father = new Man(fName, fSurname, fBirthDate, fIq, null, new HashMap<>());
            familyController.createNewFamily(mother, father);
            System.out.println("Family created successfully!");
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println("Error creating family: " + e.getMessage() + ". Please check date format (DD/MM/YYYY) and IQ.");
        }
    }

    private static void deleteFamilyByIndex() {
        System.out.print("Enter the index of the family to delete: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            if (familyController.deleteFamilyByIndex(index)) {
                System.out.println("Family at index " + index + " deleted successfully.");
            } else {
                System.out.println("Family at index " + index + " not found or could not be deleted.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private static void editFamilyByIndex() {
        System.out.print("Enter the index of the family to edit: ");
        int familyIndex = -1;
        try {
            familyIndex = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for family index.");
            scanner.nextLine();
            return;
        }

        Family familyToEdit = familyController.getFamilyById(familyIndex);

        if (familyToEdit == null) {
            System.out.println("Family not found at index " + familyIndex);
            return;
        }

        System.out.println("\n--- Edit Family Menu ---");
        System.out.println("1. Give birth to a baby");
        System.out.println("2. Adopt a child");
        System.out.println("3. Return to main menu");
        System.out.print("Enter your choice: ");

        int editChoice = -1;
        try {
            editChoice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return;
        }


        switch (editChoice) {
            case 1:
                System.out.print("Enter name for a boy: ");
                String boyName = scanner.nextLine();
                System.out.print("Enter name for a girl: ");
                String girlName = scanner.nextLine();
                try {
                    familyController.bornChild(familyToEdit, boyName, girlName);
                    System.out.println("Child born to family " + familyIndex + " successfully!");
                } catch (FamilyOverFlowException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                System.out.print("Enter child's name: ");
                String adoptedChildName = scanner.nextLine();
                System.out.print("Enter child's surname: ");
                String adoptedChildSurname = scanner.nextLine();
                System.out.print("Enter child's birth date (DD/MM/YYYY): ");
                String adoptedChildBirthDateStr = scanner.nextLine();
                System.out.print("Enter child's IQ: ");
                int adoptedChildIq = -1;
                try {
                    adoptedChildIq = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for IQ. Please enter a number.");
                    scanner.nextLine();
                    return;
                }

                try {
                    long adoptedChildBirthDate = Human.parseDateToMillis(adoptedChildBirthDateStr);
                    Human adoptedChild = new Human(adoptedChildName, adoptedChildSurname, adoptedChildBirthDate, adoptedChildIq);
                    familyController.adoptChild(familyToEdit, adoptedChild);
                    System.out.println("Child adopted to family " + familyIndex + " successfully!");
                } catch (IllegalArgumentException | DateTimeParseException e) {
                    System.out.println("Error adopting child: " + e.getMessage() + ". Please check date format (DD/MM/YYYY) and IQ.");
                } catch (FamilyOverFlowException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid choice for editing family.");
                break;
        }
    }

    private static void removeAllChildrenOlderThen() {
        System.out.print("Enter the age to remove children older than: ");
        try {
            int age = scanner.nextInt();
            scanner.nextLine();
            familyController.deleteAllChildrenOlderThen(age);
            System.out.println("Children older than " + age + " removed from all families.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }
}