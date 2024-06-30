import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends Person {
    private int doctorId;
    private String birthday;
    private String specialization;
    private ArrayList<Date> availabilities;
    private HashMap<Date,ArrayList<Appointment>> allAppointments = new HashMap<>();

    public Doctor(int doctorId, String name, String birthday, String specialization, String contactNumber) {
        super(name,contactNumber);
        this.doctorId = doctorId;
        this.birthday = birthday;
        this.specialization = specialization;
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
    public ArrayList<Date> getAvailabilities() {
        return availabilities;
    }

    public HashMap<Date, ArrayList<Appointment>> getAllAppointments() {
        return allAppointments;
    }
    public int getDoctorId() {
        return doctorId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
