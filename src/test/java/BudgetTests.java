
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

        assertFalse("Should return false as it should not be empty", budget.getAccounts().isEmpty());
        assertNotNull("Should not be null as it should be returning a account object", budget.getAccountByID(ID));
        assertEquals("Account name should be equal to BankName", "BankName", budget.getAccountByID(ID).getName());
    }
    @Test
    public void deleteAccount(){
        Budget budget = new Budget();
        UUID ID = budget.CreateAccount("BankName");

        assertFalse("Should return false as it should not be empty", budget.getAccounts().isEmpty());

        assertTrue("Should Return True after Deleting Account", budget.deleteAccountByID(ID));
        assertFalse("Should Return false as there is no Account left", budget.deleteAccountByID(ID));
        assertTrue(budget.getAccounts().isEmpty());

    }

}
