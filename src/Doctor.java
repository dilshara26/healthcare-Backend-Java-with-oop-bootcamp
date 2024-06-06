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
        Boolean isEndingWithPhysician = this.specialization.endsWith("physician");
        return isEndingWithPhysician;
    }

}
