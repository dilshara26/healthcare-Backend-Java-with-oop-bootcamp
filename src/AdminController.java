import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AdminController {

    public static ArrayList<Doctor> doctorList = new ArrayList<>();

    public static void addDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Doctor's Id: ");
        String id = scanner.nextLine();
        System.out.println("Enter Doctor's Specialization: ");
        String specialization = scanner.nextLine();
        System.out.println("Enter Doctor's Contact Information: ");
        String contact = scanner.nextLine();
        Doctor newDoctor = new Doctor(name,id,contact,specialization);
        doctorList.add(newDoctor);
    }

    public static void addAvailabilityToDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Doctor's Id you want to add availability: ");
        String id = scanner.nextLine();
        Doctor selectedDoctor = getDoctorFromList(id);
        if(selectedDoctor != null){
            System.out.println("Enter the Day you want to add Availability: ");
            String day = scanner.nextLine();
            System.out.println("Enter the Month you want to add Availability: ");
            String month = scanner.nextLine();
            System.out.println("Enter the Year you want to add Availability: ");
            String year = scanner.nextLine();
            //can perform a check to validate the date
            Date availableDay = new Date(Integer.parseInt(year), Integer.parseInt(month),Integer.parseInt(day));
            selectedDoctor.availability.add(availableDay);
            selectedDoctor.appointments.put(availableDay,new ArrayList<>());
            System.out.println("Successfully added the availability for the Dr. "+ selectedDoctor.name);
        }
        else{
            System.out.println("Invalid doctor Id");
        }


    }

    public static Doctor getDoctorFromList(String id){
        for (Doctor doc :doctorList) {
            //use getter later
            if(doc.id.equals(id)){
                return doc;
            }
        }
        return null;
    }
}
