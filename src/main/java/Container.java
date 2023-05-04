import java.util.ArrayList;
import java.util.UUID;

public abstract class Container<E extends MoneyHolder> extends MoneyHolder {

    ArrayList<E> items;

    public Container(String name) {
        super(name);
        items = new ArrayList<E>();
    }
    
    public E findByID(UUID id) {
        for(E item:items){
            if(item.getID().compareTo(ID) == 0){
                return item;
            }
        }
        return null;

    }
    public boolean removeByID(UUID id) {
        for(E item:items){
            if(item.getID().compareTo(ID) == 0){
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

    public  UUID addNew(E item){
        items.add(item);
        return item.getID();
    }


    public ArrayList<E> getAll(){
        return items;
    }



}

