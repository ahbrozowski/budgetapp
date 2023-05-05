import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction extends MoneyHolder {
    LocalDate date;
    ArrayList<Entry> entries = new ArrayList<Entry>();
    
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
        if(entries.size() != 0){
            entries = new ArrayList<Entry>();
        }
        int i = 0;
        for(Envelope envelope: envelopes){
            Entry a = new Entry(this.date, values[i], this.name, this.ID, envelope.getID());
            envelope.addNew(a);
            entries.add(a);
            i++;
        }

        return entries;
    }


    public ArrayList<Entry> getAll(){
        return entries;
    }
}
