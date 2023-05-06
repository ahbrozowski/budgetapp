import java.util.UUID;

public class Entry extends MoneyHolder{
    
    String date;
    UUID parentTransactionID;
    UUID envelopeID;

    public Entry(String date, double value, String name, UUID transaction, UUID envelope){
        super(value, name);
        this.date = date.toString();
        this.parentTransactionID = transaction;
        this.envelopeID = envelope;

    }
    public Entry(String date, double value, String name, UUID ID, UUID transaction, UUID envelope){
        super(value, name, ID);
        this.date = date.toString();
        this.parentTransactionID = transaction;
        this.envelopeID = envelope;

    }

    public UUID getEnvelope() {
        return envelopeID;
    }
    public UUID getParentTransaction() {
        return parentTransactionID;
    }
    
    public void setEnvelopeID(UUID envelopeID) {
        this.envelopeID = envelopeID;
    }

    @Override
    public String toString() {
        return name +": " + value + ", " + date.toString(); 
    }

}
