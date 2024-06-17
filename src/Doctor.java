import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor {
    public int doctorId;
    public String name;
    public String birthday;
    public String specialization;
    public String contactNumber;
    public ArrayList<Date> availabilities;
    public HashMap<Date,ArrayList<Appointment>> allAppointments = new HashMap<>();

    public Doctor(int doctorId, String name, String birthday, String specialization, String contactNumber) {
        this.doctorId = doctorId;
        this.name = name;
        this.birthday = birthday;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        availabilities = new ArrayList<>();

    }
    public boolean isPhysician() {
        Boolean isEndingWithPhysician = this.specialization.endsWith("physician");
        return isEndingWithPhysician;
    }

    public void setAvailability(Date availableDate) {
        this.availabilities.add(availableDate);
    }
    public void setAppointment(Appointment appointment, Date date){
        ArrayList<Appointment> currentAppointments= this.allAppointments.get(date);
        if(currentAppointments == null){
            ArrayList<Appointment> tempArraylist = new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppointments.put(date,tempArraylist);
        }
        else{
            currentAppointments.add(appointment);
            this.allAppointments.put(date,currentAppointments);
        }


//        this.allAppointments.put(date,)
    }
}
