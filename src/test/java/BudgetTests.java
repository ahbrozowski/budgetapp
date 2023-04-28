
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

public class BudgetTests {

    @Test
    public void addingANewAccount(){
        Budget budget = new Budget();
        UUID ID = budget.CreateAccount("BankName");

        assertFalse(budget.getAccounts().isEmpty());
        assertNotNull(budget.getAccountByID(ID));
    }

    public void deleteAccount(){
        Budget budget = new Budget();
        UUID ID = budget.CreateAccount("BankName");

        assertFalse(budget.getAccounts().isEmpty());

        assertTrue(budget.deleteAccountByID(ID));
        assertTrue(budget.getAccounts().isEmpty());

    }

}
