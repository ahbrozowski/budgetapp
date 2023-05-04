import java.util.Date;
import java.util.UUID;

public class Entry extends MoneyHolder{
    
    Date date;
    UUID parentTransactionID;
    UUID envelopeID;

    public Entry(Date date, double value, String name, UUID transaction, UUID envelope){
        super(value, name);
        this.date = date;
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


}
