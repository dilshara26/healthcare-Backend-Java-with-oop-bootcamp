public class Patient extends Person {

    private String patientId;

    public Patient(String patientId, String name, String contactNumber) {
        super(name,contactNumber);
        this.patientId = patientId;

    }
    public String getPatientId(){
        return this.patientId;
    }
    public void greeting(){
        getName();
        System.out.println("Hello +" + this.getName());
    }
    @Override
    public String getName(){
        System.out.println("Returning Name");
        System.out.println(this.getName());
        return this.getName();
    }


    public char getPatientType() {
        char firstLetter = this.patientId.charAt(0);
        return firstLetter; // Get the first character of the patient ID
    }
}
