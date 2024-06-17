import javax.print.Doc;
import java.util.*;

public class Main {
    public static void adminMenu(){
        boolean runAdmin = true;
        while (runAdmin){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
            int userObjective = scanner.nextInt();
            if(userObjective == 1){
//            get the relevant data
                Controller.addDoctor();
                System.out.println("Doctor is added");


            } else if (userObjective==2) {
                //add doc availability
               Controller.addAvailabilityForDoctor();

            } else if (userObjective==3) {
                runAdmin = false;
                System.out.println("Exit");
            }
            else {
                System.out.println("Invalid");
            }
        }


    }
    public static void patientMenu(){
        boolean  runPatient = true;

        while (runPatient){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to view doctors, press 2 to book an appointment, press 3 to view a selected doctor’s bookings, and press 4 to exit, press 5 to add a Patient");
            int userObjective = scanner.nextInt();
            if(userObjective == 1){
                Controller.viewAllDoctors();
            } else if (userObjective==2) {
                Controller.bookAppointment();
            } else if (userObjective==3) {
                System.out.println("View a selected Doctor");
            } else if (userObjective==4) {
                runPatient= false;
                System.out.println("Exit");

            } else if (userObjective==5) {
                Controller.addPatient();
            } else {
                System.out.println("Invalid");
            }

        }

    }

    public static void run(){

        boolean runMain  = true;

        while (runMain){
            Scanner scanner = new Scanner(System.in);
            System.out.println("If you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int userType = scanner.nextInt();

            if(userType == 1){
                adminMenu();
            }
            else if(userType == 2){
                patientMenu();

            } else if (userType==3) {
                runMain = false;
                System.out.println("Exit");
            }
            else {
                System.out.println("Invalid Input");
            }
        }
    }


    public static void main(String[] args) {
        Doctor sampleDoc = new Doctor(223,"Saman Kumara","22.05.1987","Gynocologist","077-333-9900");
        Patient samplePatient = new Patient("T-12", "Alice Johnson",  "555-123-4567");
        Controller.allDoctors.add(sampleDoc);
        Controller.allPatients.add(samplePatient);

        run();
//
//        // Sample Doctor objects
//        Doctor doctor1 = new Doctor(101, "John Smith", "1970-01-01", "Neurophysician", "123-456-7890");
//        Doctor doctor2 = new Doctor(102, "Jane Doe", "1980-02-02", "Cardiologist", "987-654-3210");
//
//        // Test doctor methods
//        System.out.println("Doctor 1:");
//        System.out.println("Is Physician: " + doctor1.isPhysician());
//
//        System.out.println("\nDoctor 2:");
//        System.out.println("Is Physician: " + doctor2.isPhysician());
//
//        // Sample Patient objects
//        Patient patient1 = new Patient("T-1234", "Alice Johnson", "2000-03-03", "555-123-4567");
//        Patient patient2 = new Patient("D-5678", "Bob Williams", "1990-04-04", "888-789-0123");
//
//        // Test patient methods
//        System.out.println("\nPatient 1:");
//        System.out.println("Patient Type: " + patient1.getPatientType());
//
//        System.out.println("\nPatient 2:");
//        System.out.println("Patient Type: " + patient2.getPatientType());

//        ------------
//        ------------
//        Doctor sampleDoc = new Doctor(223,"Saman Kumara","22.05.1987","Gynocologist","077-333-9900");
//        Patient samplePatient = new Patient("T-12", "Alice Johnson", "2000-03-03", "555-123-4567");
//        allDoctors.add(sampleDoc);
//        allPatients.add(samplePatient);
//        Appointment sampleAppointment = new Appointment(sampleDoc,samplePatient,"No Notes",new Date(2024, 6,12),"No Time Yet");


    }
}