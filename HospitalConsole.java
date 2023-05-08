/*
OOP Project 2: Hospital System
Students:
Hussien Aljifri 442002930
Rawad Bin Siddeq 442005646
*/
/*
working admin names:
hussien
rawad
admin
*/
package HospitalSystem;

import java.util.*; //Importing Scanner and Vector classes.
public class HospitalConsole {
    //Creating vectors.
    public static Vector<Doctor> doc = new Vector<Doctor>(0);
    public static Vector<Patient> pat = new Vector<Patient>(0);
    public static Vector<Service> ser = new Vector<Service>(0);
    //Main method. 
    public static void main(String[] args) throws DuplicateServiceIDException {
        Scanner input = new Scanner(System.in); //Creating a Scanner object.
        boolean mainLoop;
        
        //Constructing initial Doctors and adding them to the Vector.
        Doctor a = new Doctor(1,"Hussien","Aljifri","s442002930@st.uqu.edu.sa","Owner","Opthomologist","0545432650",20000);
        Doctor b = new Doctor(2,"Rawad","Bin Siddeq","442005646@st.uqu.edu.sa","Owner","Opthomologist","123456789",20000);
        doc.add(a);
        doc.add(b);
        ser.setSize(5000);
        
        //Starting page.
        System.out.println("\t***************************************"); 
        System.out.println("\t\tHospital Console");
        System.out.println("\t\tMade by: \n\t\tHussien Aljifri, 442002930 \n\t\t\t& \n\t\tRawad Bin Siddeq, 442005646");
        System.out.println("\t***************************************");
        
        //Taking the admin name from user.
        System.out.println("Please enter an administrator name:");
        String name = input.nextLine();
        
        //Checking if the admin name exists.
        if (name.equals("admin")||name.equals("hussien")||name.equals("rawad")){
            mainLoop = true;
        }
        else{
            System.out.println(ConsoleColors.RED+"Error: The name you entered does not have administrator permissions."+ConsoleColors.RESET);
            mainLoop = false;
        }
            //Start of the loop.
            while(mainLoop){ 
                System.out.println("---------------------------------------\nChoose a number between 1 and 9:\n---------------------------------------");
                System.out.println("1- Add a Doctor."); //Selection screen.
                System.out.println("2- Add a service.");
                System.out.println("3- Add a patient.");
                System.out.println("4- Show Doctor list.");
                System.out.println("5- Show patient list.");
                System.out.println("6- View Doctor information.");
                System.out.println("7- View patient information.");
                System.out.println("8- View patient bill.");
                System.out.println("9- Exit.");
                
                //Taking the users choice.
                int operation = input.nextInt(); 
                switch(operation){
                    case 1: //Adding a Doctor.
                        System.out.println("Please enter the doctors first name: ");
                        String fname = input.next();
                        System.out.println("Please enter the doctors last name: ");
                        String lname = input.next();
                        System.out.println("Please enter the doctors E-mail: ");
                        String mail = input.next();
                        System.out.println("Please enter the doctors rank: ");
                        String rank = input.next();
                        System.out.println("Please enter the doctors specialty: ");
                        String speciality = input.next();
                        System.out.println("Please enter the doctors phone number: ");
                        String number = input.next();
                        System.out.println("Please enter the doctors salary: ");
                        double salary = input.nextDouble();
                        int dID = doc.size()+1;
                        Doctor d = new Doctor(dID,fname,lname,mail,rank,speciality,number,salary);
                        doc.add(d);
                        System.out.println(ConsoleColors.GREEN+"Successfully added doctor!\nDoctor ID: "+dID+ConsoleColors.RESET);
                        break;
                        
                    case 2: //Adding a Service.
                        System.out.println("Please enter the service ID: ");
                        int sID = input.nextInt();
                        System.out.println("Please enter the patient ID: ");
                        int spID = input.nextInt();
                        if(pat.size()>spID-1 && spID-1>=0){                          
                            System.out.println("Please enter the service name: ");
                            String sName = input.next();
                            System.out.println("Please enter the service price: ");
                            double price = input.nextDouble();
                            //Checking if the Service ID exists using the vector.
                            if(ser.elementAt(sID) == null) {
                                Service s = new Service(sID,sName,price);
                                ser.setElementAt(s, sID);
                                pat.elementAt(spID-1).addService(s);
                                System.out.println(ConsoleColors.GREEN+"Successfully added service!"+ConsoleColors.RESET+"\nService ID: "+sID);
                            }
                            else{
                                throw new DuplicateServiceIDException("The Service ID you entered ("+sID+") has been used before");
                            }
                        }
                        else{
                            System.out.println(ConsoleColors.RED+"ERROR: There is no patient with that ID."+ConsoleColors.RESET);
                        }
                        break;
                        
                    case 3: //Adding a Patient.
                        System.out.println("Please enter the patients first name: ");
                        String fnamep = input.next();
                        System.out.println("Please enter the patients last name: ");
                        String lnamep = input.next();
                        System.out.println("Please enter the patients E-mail: ");
                        String mailp = input.next();
                        System.out.println("Please enter the patients type A, B or C: ");
                        String type = input.next();
                        System.out.println("Please enter the patients phone number: ");
                        String numberp = input.next();
                        System.out.println("Please enter the ID of the doctor treating the patient: ");
                        int docpatID = input.nextInt();
                        if(doc.size()>docpatID-1 && docpatID-1>=0){
                            int pID = pat.size()+1;
                            Patient p = new Patient(pID,fnamep,lnamep,mailp,type.charAt(0),numberp,docpatID);
                            pat.add(p);
                            doc.elementAt(docpatID-1).addPatient(p);
                            System.out.println(ConsoleColors.GREEN+"Successfully added patient!"+ConsoleColors.RESET+"\nPatient ID: "+pID);
                        }
                        else{
                            System.out.println(ConsoleColors.RED+"ERROR: There is no doctor with that ID."+ConsoleColors.RESET);
                        }
                        break;
                        
                    case 4: //Showing Doctor list.
                        Doctor dr;
                        for(int i = 0;i<doc.size();i++){
                            dr = doc.elementAt(i);
                            System.out.println(dr.toString());
                        }
                        break;
                        
                    case 5: //Showing patient list.
                        Patient pa;
                        for(int i = 0;i<pat.size();i++){
                            pa = pat.elementAt(i);
                            System.out.println(pa.toString());
                        }
                        break;
                        
                    case 6: //Showing Doctor details.
                        System.out.println("Please enter doctor ID: ");
                        int docID = input.nextInt();
                        if(doc.size()>docID-1 && docID-1>=0){
                            System.out.println(doc.elementAt(docID-1).details());
                        }
                        else{
                            System.out.println(ConsoleColors.RED+"ERROR: There is no doctor with that ID."+ConsoleColors.RESET);
                        }
                        break;
                    
                    case 7: //Showing Patient details.
                        System.out.println("Please enter patient ID: ");
                        int patID = input.nextInt();
                        if(pat.size()>patID-1 && patID-1>=0){
                            System.out.println(pat.elementAt(patID-1).details());
                        }
                        else{
                            System.out.println(ConsoleColors.RED+"ERROR: There is no patient with that ID."+ConsoleColors.RESET);
                        }
                        break;
                    
                    case 8: // Showing Patient's total bill.
                        System.out.println("Please enter patient ID: ");
                        int patID2 = input.nextInt();
                        if(pat.size()>patID2-1 && patID2-1>=0){
                            System.out.println("The Total Bill for the patient is: "+pat.elementAt(patID2-1).calculateBill());
                        }
                        else{
                            System.out.println(ConsoleColors.RED+"ERROR: There is no patient with that ID."+ConsoleColors.RESET);
                        }
                        break;
                        
                    case 9: //Exiting program.
                    System.out.println("Exiting from the program...");
                    System.out.println(ConsoleColors.GREEN+"Goodbye!"+ConsoleColors.RESET);
                    mainLoop = false;
                    }
                while(operation > 9 || operation < 1){ //Checking that the input was between 1 and 8.
                    System.out.println(ConsoleColors.RED+"Error: Please input an integer from 1 to 8."+ConsoleColors.RESET);
                    break;
                }
            }//End of loop.
    }
}
