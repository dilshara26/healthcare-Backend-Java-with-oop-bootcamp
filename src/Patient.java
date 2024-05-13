import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Patient {

    public String name;
    public String id;
    public String contact;
    public ArrayList<Appointment> myBookings = new ArrayList<>();
    public Patient(String name, String id, String contact ){
        this.name=name;
        this.id=id;
        this.contact=contact;
    }

    public void addToMyBooking(Appointment appointment){
        myBookings.add(appointment);
    }


}
