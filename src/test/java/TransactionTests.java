import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TransactionTests {

    @Test
    public void testCreatingEntries(){
        Account a = new Account("ally");
        Envelope savings = new Envelope("Savings", a.getID());
        Envelope food = new Envelope("food", a.getID());
        Transaction t = new Transaction(LocalDate.of(2020, 5, 7), 300, "Paycheck");

        ArrayList<Envelope> envelopes = new ArrayList<Envelope>();
        
        envelopes.add(savings);
        envelopes.add(food);
        double[] values = {100, 200};
        ArrayList<Entry> resutlingEntries;
        try {
        resutlingEntries =  t.createEntries(envelopes, values);
        } catch (Exception e) {
            fail("should not be throwing error");
            return;
        }

        assertFalse(savings.getAll().isEmpty());
        assertFalse(food.getAll().isEmpty());
        
        Entry createdForSavings = resutlingEntries.get(0);
        Entry createdForFood = resutlingEntries.get(1);

        assertEquals("should be equal to 100", 100, savings.findByID(createdForSavings.getID()).getValue(), 0);
        assertEquals("should be equal to 100", 200, food.findByID(createdForFood.getID()).getValue(), 0);

        assertFalse("Should not be empty", t.getEntryIDs().isEmpty());
        
    }

    @Test
    public void testThatErrorIsThrown(){
        Account a = new Account("ally");
        Envelope savings = new Envelope("Savings", a.getID());
        Envelope food = new Envelope("food", a.getID());
        Transaction t = new Transaction(LocalDate.of(2020, 5, 7), 300, "Paycheck");

        ArrayList<Envelope> envelopes = new ArrayList<Envelope>();
        
        envelopes.add(savings);
        envelopes.add(food);
        double[] values = {100, 100};
        
        try {
            t.createEntries(envelopes, values);
            fail("should be throwing error");
        } catch (Exception e) {
            assertNotNull(e);
            return;
        }
    }

}

