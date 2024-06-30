public class Patient extends Person {

    private String patientId;

    public Patient(String patientId, String name, String contactNumber) {
        super(name,contactNumber);
        this.patientId = patientId;

    }
    public String getPatientId(){
        return this.patientId;
    }


    public char getPatientType() {
        char firstLetter = this.patientId.charAt(0);
        return firstLetter; // Get the first character of the patient ID
    }
}
