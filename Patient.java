
package HospitalSystem;

import java.util.*;

public class Patient {
    //Declaring instance variables.
    static private int id ;
    final private String firstName ;
    final private String lastName ;
    final private String email;
    final private char type;
    final private String number;
    final private int docID;
    Vector<Service> services = new Vector<Service>(0);
    //Patient Constructor method.
    public Patient(int id, String firstName, String lastName, String email, char type, String number, int docID){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.number = number;
        this.docID = docID;
    }
    //Adding services to the Vector.
    public void addService(Service s){
        services.add(s);
    }
    //Getter for ID.
    public int getID(){
        return id;
    }
    //Calculating the total bill.
    public double calculateBill(){
        double total = 0;
        for(int i=0;i < services.size();i++){
            total =+ services.elementAt(i).getPrice();
        }
        double discountTotal;
        if(type == 'a'||type == 'A'){
            double discount =  total*0.4;
            discountTotal = total - discount;
        }
        else{
            discountTotal = total;
        }
        return discountTotal;
    }
    //Details method for specific patient details.
    public String details(){
        String serviceIDs = "";
        for(int i=0;i<services.size();i++){
            String iserviceID = Integer.toString(services.elementAt(i).getID());
            serviceIDs = serviceIDs+iserviceID + ", ";
        }
        return "Full Name: "+firstName+" "+lastName+"\nE-Mail: "+email+"\nType: "+type+"\nPhone: "+number+"\nDoctor: "+docID+"\nServices: "+serviceIDs;
    }
    //toString method for patient list.
    @Override
    public String toString(){
        return "Patient: "+id+"   Name: "+firstName+" "+lastName+"   Type: "+type+"   Phone: "+number+"   Number of services: "+services.size();
    }
}
