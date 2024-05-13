import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Doctor {

    public String name;
    public String id;
    public String contact;
    public String specialization;
    public ArrayList<Date> availability = new ArrayList<>();
    public HashMap<Date,ArrayList<Appointment>> appointments = new HashMap<>();
    public Doctor (String name, String id, String contact, String specialization ){
        this.name=name;
        this.id=id;
        this.contact=contact;
        this.specialization= specialization;
    }
    public void addToDoctorAppointments(Date date, Appointment appointment){
        System.out.println(date);
        ArrayList<Appointment> appointmentsForTheSelectedDate =  appointments.get(date);
        if(appointmentsForTheSelectedDate != null){
            appointmentsForTheSelectedDate.add(appointment);
            appointments.put(date,appointmentsForTheSelectedDate);
        }
    
        System.out.println(appointments.toString());
        for (Map.Entry<Date,ArrayList<Appointment>> app: appointments.entrySet()) {
            System.out.println(app.getKey());
            System.out.println(app.getValue());
        }

    }

}
