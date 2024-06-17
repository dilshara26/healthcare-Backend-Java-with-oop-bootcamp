import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();
    public static void addDoctor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String name = sc.nextLine();
        System.out.println("Enter your birthday: ");
        String birthday = sc.nextLine();
        System.out.println("Enter your Specialization: ");
        String specialization = sc.nextLine();
        System.out.println("Enter your Contact: ");
        String contact = sc.nextLine();

        Random random = new Random();
        Doctor tempDoctor = new Doctor(random.nextInt(), name, birthday,specialization,contact);

        allDoctors.add(tempDoctor);
    }
    public static void addAvailabilityForDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the doctor Id you want add availability: ");
        int docId = scanner.nextInt();
        Doctor selectedDoctor = null;
//                we need to fetch the doctor from the arraylist
        for (Doctor doc:allDoctors) {
            if(doc.doctorId == docId){
                selectedDoctor = doc;
            }
        }
//                if the doctor is not existing, we need to sout "No Doctor found"
        if(selectedDoctor == null){
            System.out.println("No Doctor Found");
            return;
        }
//                if the doctor is existing, take the date
        System.out.println("Enter the Day you want to add Availability: ");
        int day = scanner.nextInt();
        System.out.println("Enter the Month you want to add Availability: ");
        int month = scanner.nextInt();
        System.out.println("Enter the Year you want to add Availability: ");
        int year = scanner.nextInt();
        Date bookingDate = new Date(year,month,day);
//                add the availability for the doctor
        selectedDoctor.setAvailability(bookingDate);
    }
    public static void viewAllDoctors(){
        for (Doctor doc: allDoctors) {
            System.out.println(doc.name + " has a specialization of " + doc.specialization +  " has a id of " + doc.doctorId + " and has a availability of " + doc.availabilities.toString());
            System.out.println(doc.doctorId);
        }
    }

    public static void addPatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter patient's Id: ");
        String id = scanner.nextLine();
        System.out.println("Enter patient's Contact Information: ");
        String contact = scanner.nextLine();
        Patient tempPatient = new Patient(id,name,contact);
        allPatients.add(tempPatient);
        System.out.println("Patient is Added");
        System.out.println(allPatients.toString());
    }
    public static void bookAppointment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's Id you want to make an appointment: ");
        int docId = scanner.nextInt();
        System.out.println("Enter you patient's Id: ");
        String patientId = scanner.next();

        System.out.println("Enter the Day you want to add Availability: ");
        String day = scanner.next();
        System.out.println("Enter the Month you want to add Availability: ");
        String month = scanner.next();
        System.out.println("Enter the Year you want to add Availability: ");
        String year = scanner.next();

//        get patient and doctor
        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoc = getDoctorById(docId);
        if(selectedDoc == null || selectedPatient ==null){
            System.out.println("Invalid doc or patient id");
            return;
        }
        Date appointmentDate = new Date(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));

//        check the availability and slots
//        calculate appointment Time
//        make the appointment
        Appointment appointment = new Appointment(selectedDoc,selectedPatient,"No Notes",appointmentDate,"");
        selectedDoc.setAppointment(appointment,appointmentDate);
        System.out.println(selectedDoc.allAppointments.toString());
    }

    public static Patient getPatientById(String id){
        for(Patient patient : allPatients){
            if(patient.patientId.equals(id)){
                return patient;
            }
        }
        return null;
    }
    public static Doctor getDoctorById(int id){
        for(Doctor doc : allDoctors){
            if(doc.doctorId == id){
                return doc;
            }
        }
        System.out.println("No doctor Found");
        return null;
    }

}