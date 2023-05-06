import java.util.UUID;

public class Budget extends Container<Account>{

    public Budget(String name) {
        super(name);
    }
    
    public Budget(String name, UUID id) {
        super(name, id);
    }
    
    
}
