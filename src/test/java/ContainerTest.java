import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;


public class ContainerTest {
    
    Account ally = new Account("Ally");
   Container<Entry> savings = new Container<Entry>("savings");

    @Test
    public void createItem(){

        UUID savingsID = savings.getID();
        UUID returnedID = ally.addNew(savings);
        assertEquals("UUID did not match or was not returned", savingsID, returnedID);

        assertEquals("Did not find the correct item", 0, savings.compareTo(ally.findByID(savingsID)));

    }
    @Test
    public void calculatedValue(){
        Transaction t = new Transaction("2023-01-10", 100, "walmart shopping");
        Transaction t2 = new Transaction("2023-01-10", 500, "Paycheck");
        Entry a = new Entry("2023-01-10", -23.57, "walmart shopping", t.getID() , savings.getID() );
        Entry b = new Entry("2023-01-10", 250 , "Paycheck", t2.getID() , savings.getID());

        savings.addNew(a);
        savings.addNew(b);

        ally.addNew(savings);
        assertEquals("Envelope value not calculated correctly", 226.43, savings.getValue(), 0);
        assertEquals("Account value not calculated correctly", 226.43, ally.getValue(), 0);

    }

    @Test
    public void deleteItems(){
        Transaction t = new Transaction("2023-01-10", 100, "walmart shopping");
        Transaction t2 = new Transaction("2023-01-10", 500, "Paycheck");
        Entry a = new Entry("2023-01-10", -23.57, "walmart shopping", t2.getID() , savings.getID() );
        Entry b = new Entry("2023-01-10", 250 , "Paycheck", t.getID() , savings.getID());

        savings.addNew(a);
        savings.addNew(b);

        ally.addNew(savings);

        assertTrue("Removing item should return true" , savings.removeByID(a.getID()));
        assertEquals("Value should change now that item is removed", 250, savings.getValue(), 0);
        assertTrue("Removing item should return true" , savings.removeByName(b.getName()));
        assertEquals("Value should change now that item is removed", 0, savings.getValue(), 0);

    }

}
