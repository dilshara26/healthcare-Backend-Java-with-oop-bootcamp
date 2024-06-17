public class Patient {
    public String patientId;
    public String name;
    public String birthday;
    public String contactNumber;

    public Patient(String patientId, String name, String contactNumber) {

        this.patientId = patientId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public char getPatientType() {
        char firstLetter = this.patientId.charAt(0);
        return firstLetter; // Get the first character of the patient ID
    }
}
