public class Doctor {
    public int doctorId;
    public String name;
    public String birthday;
    public String specialization;
    public String contactNumber;

    public Doctor(int doctorId, String name, String birthday, String specialization, String contactNumber) {
        this.doctorId = doctorId;
        this.name = name;
        this.birthday = birthday;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }
    public boolean isPhysician() {
        return specialization.toLowerCase().endsWith("physician"); // Check if specialization ends with "physician" (case-insensitiveness is done by converting to lowercase)
    }

}
