
package HospitalSystem;

import java.util.*;

public class Doctor {
    //Declaring instance variables.
    static private int id ;
    final private String firstName ;
    final private String lastName ;
    final private String email;
    final private String rank;
    final private String specialty;
    final private String number;
    final private double salary;
    Vector<Patient> patients = new Vector<Patient>(0);
    //Doctor constructor method.
    public Doctor(int id, String firstName, String lastName, String email, String rank, String specialty, String number, double salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rank = rank;
        this.specialty = specialty;
        this.number = number;
        this.salary = salary;
    }
    //Method for adding patients to the doctor.
    public void addPatient(Patient p){
        patients.add(p);
    }
    //Details method for specific doctor details.
    public String details(){
        String patientIDs = "";
        for(int i=0;i<patients.size();i++){
            String ipatientID = Integer.toString(patients.elementAt(i).getID());
            patientIDs = patientIDs+ipatientID + ", ";
        }
        return "Full Name: "+firstName+" "+lastName+"\nE-Mail: "+email+"\nRank: "+rank+"\nSpecialty: "+specialty+"\nPhone: "+number+"\nSalary: "+salary+"\nPatients: "+patientIDs;
    }
    //toString method for Doctor list.
    @Override
    public String toString(){
        return "Doctor: "+id+"   Name: "+firstName+" "+lastName+"   Rank: "+rank+"   specialty: "+specialty+"   Number of patients: "+patients.size();
    }
}
