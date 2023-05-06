import java.util.ArrayList;
import java.util.UUID;

public class Transaction extends MoneyHolder {
    String date;
    ArrayList<UUID> entryIDs = new ArrayList<UUID>();
    

    public Transaction(String date, double value, String name) {
        super(value, name);
        this.date = date;
    }

    public Transaction(String date, double value, String name, UUID id) {
        super(value, name, id);
        this.date = date;
    }
    
    
    public ArrayList<Entry> createEntries(ArrayList<Container<Entry>> envelopes, double[] values) throws Exception{
        double entriesValue = 0;
        for(double value: values){
            entriesValue += value;
        }
        if(entriesValue != this.value){
            throw new Exception("Imputed Values do not match the Transaction value");
        }
        if(entryIDs.size() != 0){
            entryIDs = new ArrayList<UUID>();
        }
        int i = 0;
        ArrayList<Entry> entries = new ArrayList<Entry>();
        for(Container<Entry>envelope: envelopes){
            Entry a = new Entry(this.date, values[i], this.name, this.ID, envelope.getID());
            envelope.addNew(a);
            entries.add(a);
            entryIDs.add(a.getID());
            i++;
        }

        return entries;
    }


    public ArrayList<UUID> getEntryIDs(){
        return entryIDs;
    }
}
