
package HospitalSystem;
//Creating Duplicate Service ID Exception.
public class DuplicateServiceIDException extends Exception {
    public DuplicateServiceIDException(String message){
        super(message);
    }
}
