import java.util.*;

public class PatientController {
    public static int NUMBER_OF_SLOTS_PER_DAY = 5;
    public static ArrayList<Patient> patientList = new ArrayList<>();

    public static void registerPatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter patient's Id: ");
        String id = scanner.nextLine();
        System.out.println("Enter patient's Contact Information: ");
        String contact = scanner.nextLine();
        Patient patient = new Patient(name,id,contact);
        patientList.add(patient);
    }
    public static void bookAnAppointment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's Id you want to make an appointment: ");
        String docId = scanner.nextLine();
        System.out.println("Enter you patient's Id: ");
        String patientId = scanner.nextLine();

        System.out.println("Enter the Day you want to add Availability: ");
        String day = scanner.nextLine();
        System.out.println("Enter the Month you want to add Availability: ");
        String month = scanner.nextLine();
        System.out.println("Enter the Year you want to add Availability: ");
        String year = scanner.nextLine();
        //can perform a check to validate the date
        Date bookingDate = new Date(Integer.parseInt(year), Integer.parseInt(month),Integer.parseInt(day));
        Doctor doctor = AdminController.getDoctorFromList(docId);

        if(doctor == null){
            System.out.println("Invalid Doctor Id");
            return;
        }
        if(getPatientById(patientId) == null){
            System.out.println("Invalid Patient Id");
            return;
        }

        Boolean isAvailable = checkAvailability(doctor,bookingDate);

        if(isAvailable){
            String bookingTime = getTimeForaBooking(doctor,bookingDate);
            if(bookingTime != null){
                System.out.println("Enter any special note you want to add: ");
                String notes = scanner.nextLine();
                Appointment newAppointment = new Appointment(doctor,getPatientById(patientId),notes,bookingDate,bookingTime);
                getPatientById(patientId).addToMyBooking(newAppointment);
                doctor.addToDoctorAppointments(bookingDate,newAppointment);
            }
            else{
                System.out.println("All the slots are filled for the doctor ");
            }

        }
        else{
            System.out.println("Doctor is not available on the day you selected");
        }

    }
    public static Patient getPatientById(String id){
        for(Patient patient : patientList){
            if(patient.id.equals(id)){
                return patient;
            }
        }
        return null;
    }

    private static Boolean checkAvailability(Doctor selectedDoctor, Date dateOfBooking){

        for (Date day : selectedDoctor.availability){
            if(day.equals(dateOfBooking)){
                return true;
            }
        }
        return  false;
    }
    private static String getTimeForaBooking(Doctor selectedDoctor, Date dateOfBooking){

        for (Map.Entry<Date,ArrayList<Appointment>> appointment: selectedDoctor.appointments.entrySet()) {
            if(appointment.getKey().equals(dateOfBooking) && appointment.getValue().size()<= NUMBER_OF_SLOTS_PER_DAY){
                System.out.println("We can make an appointment");
                int numberOfSlots = appointment.getValue().size();
                String time = String.valueOf(17+numberOfSlots) + ":00";
                System.out.println(dateOfBooking.getTime());
                return time;
            }
        }


        return null;
    }

}
