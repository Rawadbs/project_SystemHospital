
package HospitalSystem;

public class Service {
    //Declaring instance variables.
    static private int id ;
    final private String name ;
    final private double price ;
    //Service constructor method.
    public Service(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    //Getter for Price.
    public double getPrice(){
        return price;
    }
    //Getter for ID.
    public int getID(){
        return id;
    }
}
