import java.util.ArrayList;
import java.util.UUID;

public class Account extends Container<Container<Entry>>  {

    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String name) {
        super(name);
    }   

    public Account(String name, UUID id) {
        super(name, id);
    } 
    


    public Transaction getTransactionByID(){
        for(Transaction t:transactions){
            if(t.getID().compareTo(ID) == 0){
                return t;
            }
        }
        return null;

    }

    public UUID addTransaction(Transaction transaction){
        transactions.add(transaction);
        return transaction.getID();
    }
}
