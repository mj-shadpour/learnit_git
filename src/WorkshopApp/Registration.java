package WorkshopApp;
import java.util.*;
public class Registration {
    int confirmationNumber;
    int workshopId;
    String name;

    public Registration(int confirmationNumber, int workshopId, String name) {
        this.confirmationNumber = confirmationNumber;
        this.workshopId = workshopId;
        this.name = name;
    }

    public Registration(Registration other) {
        this(other.confirmationNumber, other.workshopId, other.name);
    }

    public String toString() {
        return "#" + confirmationNumber + " " + name + " @workshop " + workshopId;
    }
}




