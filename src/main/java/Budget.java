import java.util.ArrayList;
import java.util.UUID;

public class Budget {

    ArrayList<Account> accounts = new ArrayList<Account>();

    public Budget(){

    }

    public UUID CreateAccount(String accountName) {
        UUID uuid = UUID.randomUUID();
        Account a = new Account(accountName, uuid);
        accounts.add(a);
        return uuid;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByID(UUID ID) {
        for(Account account:accounts){
            if(account.getID().compareTo(ID) == 0){
                return account;
            }
        }
        return null;
    }

    public boolean deleteAccountByID(UUID iD) {
        return false;
    }

}
