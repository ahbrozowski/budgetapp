import java.util.UUID;

public class MoneyHolder implements Comparable<MoneyHolder> {
    double value;
    UUID ID;
    String name;

    public MoneyHolder(String name){
        this.name = name;
        value = 0;
        this.ID = UUID.randomUUID();
    }

    public MoneyHolder(String name, UUID id){
        this.name = name;
        value = 0;
        this.ID = id;
    }

    public MoneyHolder(double value, String name){
        this.name = name;
        this.value = value;
        this.ID = UUID.randomUUID();
    }

    public MoneyHolder(double value, String name, UUID ID){
        this.name = name;
        this.value = value;
        this.ID = ID;
    }


    public UUID getID() {
        return this.ID;
    }

    public double getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    @Override
    public int compareTo(MoneyHolder arg0) {
        if(this.getID().compareTo(arg0.getID()) != 0){
            return this.getID().compareTo(arg0.getID());
        }
        return 0;
    }

}
