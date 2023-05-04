import java.util.ArrayList;
import java.util.UUID;

public class Budget {

    ArrayList<Account> accounts = new ArrayList<Account>();

    public Budget(){

    }

    public UUID CreateAccount(String accountName) {
        Account a = new Account(accountName);
        accounts.add(a);
        return a.getID();
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

    public boolean deleteAccountByID(UUID ID) {
        for(Account account:accounts){
            if(account.getID().compareTo(ID) == 0){
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

}
