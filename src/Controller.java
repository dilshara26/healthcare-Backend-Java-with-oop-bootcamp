import java.util.*;

public class Controller {
    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();
    public static int NUMBER_OF_SLOTS = 5;
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
            if(doc.getDoctorId() == docId){
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
            System.out.println(doc.getName() + " has a specialization of " + doc.getSpecialization() +  " has a id of " + doc.getDoctorId() + " and has a availability of " + doc.getAvailabilities().toString());
            System.out.println(doc.getDoctorId());
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

        System.out.println("Enter the Day you want to add Appointment: ");
        String day = scanner.next();
        System.out.println("Enter the Month you want to add Appointment: ");
        String month = scanner.next();
        System.out.println("Enter the Year you want to add Appointment: ");
        String year = scanner.next();

//        get patient and doctor
        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoc = getDoctorById(docId);
        if(selectedDoc == null || selectedPatient ==null){
            System.out.println("Invalid doc or patient id");
            return;
        }
        Date appointmentDate = new Date(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));

//        check the availability
        Boolean isAvailable = checkAvailability(selectedDoc,appointmentDate);
        if(isAvailable){
            String appTime = getTimeForBooking(selectedDoc,appointmentDate);
            if(appTime != null){
                Appointment appointment = new Appointment(selectedDoc,selectedPatient,"No Notes",appointmentDate,"");
                selectedDoc.setAppointment(appointment,appointmentDate);
                System.out.println(selectedDoc.getAllAppointments().toString());
            }
            else {
                System.out.println("All the slots are filled");
            }
            //        calculate appointment Time and slot availability
            //        make the appointment
        }
        else {
            System.out.println("Doctor is not available on the selected Date");
        }

    }
    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking){
        for (Map.Entry<Date,ArrayList<Appointment>> appointment: selectedDoctor.getAllAppointments().entrySet()) {
            if(appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size();
                if(numberOfSlots > NUMBER_OF_SLOTS-1){
                    return null;
                }
                System.out.println("We can make a booking");
                int time = 17 + appointment.getValue().size();
                String strTime = time + " : 00";
                return strTime;
            }
        }
        return "17: 00";
    }

    private static Boolean checkAvailability(Doctor selectedDoctor, Date dateOfBooking){
        for (Date day: selectedDoctor.getAvailabilities()) {
            if(day.equals(dateOfBooking)){
                return true;
            }
        }

        return false;
    }

    public static Patient getPatientById(String id){
        for(Patient patient : allPatients){
            if(patient.getPatientId().equals(id)){
                return patient;
            }
        }
        return null;
    }
    public static Doctor getDoctorById(int id){
        for(Doctor doc : allDoctors){
            if(doc.getDoctorId() == id){
                return doc;
            }
        }
        System.out.println("No doctor Found");
        return null;
    }


}
