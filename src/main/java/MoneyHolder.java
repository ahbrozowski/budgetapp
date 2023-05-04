import java.util.UUID;

public abstract class MoneyHolder {
    double value;
    UUID ID;
    String name;

    public MoneyHolder(String name){
        this.name = name;
        value = 0;
        ID = UUID.randomUUID();
    }

    public MoneyHolder(double value, String name){
        this.name = name;
        this.value = value;
        ID = UUID.randomUUID();
    }


    public UUID getID() {
        return ID;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
