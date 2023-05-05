import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Transaction extends MoneyHolder {
    LocalDate date;
    ArrayList<UUID> entryIDs = new ArrayList<UUID>();
    
    public Transaction(LocalDate date, double value, String name) {
        super(value, name);
        this.date = date;
    }
    
    public ArrayList<Entry> createEntries(ArrayList<Envelope> envelopes, double[] values) throws Exception{
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
        for(Envelope envelope: envelopes){
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
