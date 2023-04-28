import java.util.UUID;

public class Account {

    String name;
    UUID ID;

    public Account(String name, UUID uuid) {
        this.name = name;
        this.ID = uuid;
    }

    public UUID getID() {
        return ID;
    }
    
    

}
