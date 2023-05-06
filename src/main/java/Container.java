import java.util.ArrayList;
import java.util.UUID;

public class Container<E extends MoneyHolder> extends MoneyHolder {

    ArrayList<E> items;

    public Container(String name) {
        super(name);
        items = new ArrayList<E>();
    }
    public Container(String name, UUID id) {
        super(name, id);
        items = new ArrayList<E>();
    }
    
    public E findByID(UUID inputedUUID) {
        for(E item:items){
            if(item.getID().equals(inputedUUID)){
                return item;
            }
        }
        return null;

    }

    public E findByName(String name) {
        String lowerName = name.toLowerCase();
        for(E item:items){
            if(item.getName().toLowerCase().equals(lowerName)){
                return item;
            }
        }
        return null;

    }

    public boolean removeByID(UUID inputedUUID) {
        for(E item:items){
            if(item.getID().equals(inputedUUID)){
                items.remove(item);
                return true;
            }
        }
        return false;
    }


    public boolean removeByName(String name) {
        String lowerName = name.toLowerCase();
        for(E item:items){
            if(item.getName().toLowerCase().equals(lowerName)){
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public double getValue(){
        double calculatedValue = 0;
        for(E item:items){
            calculatedValue += item.getValue();
        }
        return calculatedValue;
    } 

    public UUID addNew(E item){
        items.add(item);
        return item.getID();
    }


    public ArrayList<E> getAll(){
        return items;
    }

    @Override
    public String toString() {

        String output = "";

        for (E item : items) {
            output = output.concat(item.getName() + "\n");
        }

        return output;
    }



}

