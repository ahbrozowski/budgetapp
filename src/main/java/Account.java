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

    public boolean removeTransactionByName(String name) {
        String lowerName = name.toLowerCase();

        Transaction t = null;
        boolean found = false;
        for(Transaction transaction:transactions){
            if(transaction.getName().toLowerCase().equals(lowerName)){
                t = transaction;
                found = true;
            }
        }

        if(found){
            for (UUID entryID : t.getEntryIDs()) {
                for (Container<Entry> envelope : items) {
                    envelope.removeByID(entryID);
                }
                
            }
            transactions.remove(t);
        }


        return found;
    }


    public String printTransactions(){
        String output = "";

            for (Transaction t : transactions) {
                output = output.concat(t.getName() + "\n");
            }

        return output;
    }
}
