import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);

        // Ask the user to choose between running their own test or the built-in test cases
        System.out.println("Choose an option:");
        System.out.println("1. Run your own percentage to GPA test");
        System.out.println("2. Run built-in test cases");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // User chooses to run their own test
            boolean continueTesting = true;

            while (continueTesting) {
                double percentage = 0.0;
                boolean validInput;

                do {
                    // Prompt the user to enter their percentage.
                    System.out.println("Enter your percentage (0.0 to 100.0):");
                    try {
                        // Attempt to read the percentage input as a double.
                        percentage = scanner.nextDouble();

                        // Check if the percentage is within the valid range (0.0 to 100.0).
                        validInput = percentage >= 0.0 && percentage <= 100.0;
                        if (!validInput) {
                            // Inform the user if the percentage is out of range.
                            System.out.println("Invalid percentage entered. Please enter a value between 0.0 and 100.0.");
                        }
                    } catch (Exception e) {
                        // Handle cases where the user enters non-numeric input (e.g., letters).
                        System.out.println("Invalid input. Please enter a numeric percentage between 0.0 and 100.0.");
                        // Clear the invalid input from the scanner.
                        scanner.next();
                        validInput = false;
                    }
                } while (!validInput);

                // Calculate GPA using a helper method
                double gpa = calculateGPA(percentage);

                // Display the calculated GPA.
                System.out.println("Your GPA is: " + gpa);

                // Ask the user if they want to test another percentage.
                System.out.println("Would you like to test another percentage? (y/n):");
                String userResponse = scanner.next();
                // Check if the user response indicates they want to exit.
                if (userResponse.equalsIgnoreCase("n")) {
                    continueTesting = false;
                }
            }
        } else if (choice == 2) {
            // Run built-in test cases
            System.out.println("\nPre-defined test cases");

            // Normal test cases
            System.out.println("Normal");
            testPercentage(96.0); // Expected: GPA: 4.0
            testPercentage(90.5); // Expected: GPA: 3.5
            testPercentage(75.0); // Expected: GPA: 2.0

            System.out.println("-------------------------");

            // Edge test cases
            System.out.println("Edge");
            testPercentage(-5.0); // Expected: Invalid input
            testPercentage(105.0); // Expected: Invalid input
            testPercentage('a'); // Expected: Invalid input
        } else {
            System.out.println("Invalid choice. Program will now exit.");
        }

        // Close the scanner to release resources after the program ends.
        scanner.close();
        // Notify the user that the program has ended.
        System.out.println("Program ended. Thanks for using the Percentage to GPA converter!");
    }

    public static void testPercentage(Object percentageInput) {
        try {
            // Check if the input is of type Double
            if (percentageInput instanceof Double) {
                double percentage = (double) percentageInput;
                // Calculate GPA using the helper method
                double gpa = calculateGPA(percentage);
                System.out.println("Test Percentage " + percentage + ": GPA: " + gpa);
            } else {
                System.out.println("Test Percentage " + percentageInput + ": Invalid input. Please enter a numeric percentage.");
            }
        } catch (Exception e) {
            System.out.println("Test Percentage " + percentageInput + ": Error during testing: " + e.getMessage());
        }
    }

    // Helper method to calculate GPA based on percentage
    public static double calculateGPA(double percentage) {
        if (percentage >= 95.0) return 4.0;
        else if (percentage >= 94.0) return 3.9;
        else if (percentage >= 93.0) return 3.8;
        else if (percentage >= 92.0) return 3.7;
        else if (percentage >= 91.0) return 3.6;
        else if (percentage >= 90.0) return 3.5;
        else if (percentage >= 89.0) return 3.4;
        else if (percentage >= 88.0) return 3.3;
        else if (percentage >= 87.0) return 3.2;
        else if (percentage >= 86.0) return 3.1;
        else if (percentage >= 85.0) return 3.0;
        else if (percentage >= 84.0) return 2.9;
        else if (percentage >= 83.0) return 2.8;
        else if (percentage >= 82.0) return 2.7;
        else if (percentage >= 81.0) return 2.6;
        else if (percentage >= 80.0) return 2.5;
        else if (percentage >= 79.0) return 2.4;
        else if (percentage >= 78.0) return 2.3;
        else if (percentage >= 77.0) return 2.2;
        else if (percentage >= 76.0) return 2.1;
        else if (percentage >= 75.0) return 2.0;
        else if (percentage >= 74.0) return 1.9;
        else if (percentage >= 73.0) return 1.8;
        else if (percentage >= 72.0) return 1.7;
        else if (percentage >= 71.0) return 1.6;
        else if (percentage >= 70.0) return 1.5;
        else if (percentage >= 69.0) return 1.4;
        else if (percentage >= 68.0) return 1.3;
        else if (percentage >= 67.0) return 1.2;
        else if (percentage >= 66.0) return 1.1;
        else if (percentage >= 65.0) return 1.0;
        return 0.0;
    }
}
