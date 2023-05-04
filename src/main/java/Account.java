import java.util.ArrayList;

public class Account extends Container<Envelope>  {

    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String name) {
        super(name);
    }   


    public Transaction getTransactionByID(){
        for(Transaction t:transactions){
            if(t.getID().compareTo(ID) == 0){
                return t;
            }
        }
        return null;

    }
}
