import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("If you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int userType = scanner.nextInt();

            if (userType == 1) {
                boolean patientD = true;
                while (patientD) {
                    System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
                    int userObjective = scanner.nextInt();
                    if (userObjective == 1) {
                        System.out.println("Add a doctor");
                    } else if (userObjective == 2) {
                        System.out.println("Add doctor availability");
                    } else if (userObjective == 3) {
                        patientD = false;
                        System.out.println("Exit");
                    } else {
                        System.out.println("Invalid");
                    }
                }
            } else if (userType == 2) {
                boolean runPatient = true;
                while (runPatient) {
                    System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor’s bookings, and press 4 to exit");
                    int userObjective = scanner.nextInt();
                    if (userObjective == 1) {
                        System.out.println("view doctors list");
                    } else if (userObjective == 2) {
                        System.out.println("Book an appointment");
                    } else if (userObjective == 3) {
                        System.out.println("View a selected Doctor");
                    } else if (userObjective == 4) {
                        runPatient = false;
                        System.out.println("Exit");

                    } else {
                        System.out.println("Invalid");
                    }
                }
            } else if (userType == 3) {
                mainMenu = false;
                System.out.println("Exit");
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}