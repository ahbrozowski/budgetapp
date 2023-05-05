import java.util.UUID;

public class Envelope extends Container<Entry> {

    UUID accountID;
   
    public Envelope(String name, UUID accountID) {
        super(name);
        this.accountID = accountID;
    }

    
}
