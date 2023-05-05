import java.time.LocalDate;
import java.util.UUID;

public class Entry extends MoneyHolder{
    
    LocalDate date;
    UUID parentTransactionID;
    UUID envelopeID;

    public Entry(LocalDate date, double value, String name, UUID transaction, UUID envelope){
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
