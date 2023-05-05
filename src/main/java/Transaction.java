import java.time.LocalDate;

public class Transaction extends MoneyHolder {
    LocalDate date;
    public Transaction(LocalDate date, double value, String name) {
        super(value, name);
        this.date = date;
    }
    
}
