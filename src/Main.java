import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean mainMenuRun = true;
        while(mainMenuRun){

            System.out.println("If you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int userType = scanner.nextInt();

            if(userType == 1){
                Boolean patientMenuRun = true;

                while (patientMenuRun){
                    System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
                    int userObjective = scanner.nextInt();
                    if(userObjective == 1){
                        System.out.println("Add a doctor");
                        AdminController.addDoctor();
                    } else if (userObjective==2) {
                        System.out.println("Add doctor availability");
                        AdminController.addAvailabilityToDoctor();
                    } else if (userObjective==3) {
                        System.out.println("Exit");
                        patientMenuRun = false;
                    }
                    else {
                        System.out.println("Invalid");
                    }
                }

            }
            else if(userType == 2){
                Boolean runPatientMenu = true;
                while (runPatientMenu){
                    System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor’s bookings, press 4 to register patient and press 5 to Exit");
                    int userObjective = scanner.nextInt();
                    if(userObjective == 1){
                        System.out.println("view doctors list");
                    } else if (userObjective==2) {
                        System.out.println("Book an appointment");
                        PatientController.bookAnAppointment();
                    } else if (userObjective==3) {
                        System.out.println("View a selected Doctor");
                    } else if (userObjective==4) {
                        System.out.println("Register Patient");
                        PatientController.registerPatient();

                    } else if (userObjective==5) {
                        runPatientMenu= false;
                        System.out.println("Exit");

                    } else {
                        System.out.println("Invalid");
                    }
                }

            } else if (userType==3) {
                System.out.println("Exit");
                mainMenuRun= false;

            }
            else {
                System.out.println("Invalid Input");
            }


        }

    }
}